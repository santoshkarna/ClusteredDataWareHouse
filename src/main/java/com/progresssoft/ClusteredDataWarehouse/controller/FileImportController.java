package com.progresssoft.ClusteredDataWarehouse.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.progresssoft.ClusteredDataWarehouse.model.UploadFileModel;
import com.progresssoft.ClusteredDataWarehouse.model.UploadSummaryReport;
import com.progresssoft.ClusteredDataWarehouse.service.FileImportService;
import com.progresssoft.ClusteredDataWarehouse.service.SummaryReportService;

@Controller
public class FileImportController {

	@Autowired
	SummaryReportService summaryReportService;

	@Autowired
	FileImportService fileImportService;

	private static final Logger LOGGER = LoggerFactory.getLogger(FileImportController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/upload")
	public ModelAndView showPage() {

		final ModelAndView modelAndView = new ModelAndView("upload-page");
		modelAndView.addObject("fileUploadForm", new UploadFileModel());
		return modelAndView;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		LOGGER.error("Failed importing file.", e);

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("upload-page");
		modelAndView.addObject("fileUploadForm", new UploadFileModel());
		modelAndView.addObject("error", true);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/upload/file")
	public ModelAndView uploadFile(@ModelAttribute("fileUploadForm") @Valid UploadFileModel form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("upload-page");
		}

		MultipartFile multipartFile = form.getFile();

		UploadSummaryReport summaryReportModel = new UploadSummaryReport();
		summaryReportModel.setSourceFileName(multipartFile.getOriginalFilename());
		final ModelAndView modelAndView = new ModelAndView();

		if (fileImportService.isFileAlreadyImported(multipartFile.getOriginalFilename())) {
			modelAndView.setViewName("upload-page");
			modelAndView.addObject("fileUploadForm", new UploadFileModel());
			modelAndView.addObject("alreadyimported", true);
			return modelAndView;
		}

		fileImportService.fileUpload(multipartFile, summaryReportModel);
		modelAndView.setViewName("upload-page");
		modelAndView.addObject("fileUploadForm", new UploadFileModel());
		modelAndView.addObject("success", true);

		return modelAndView;

	}

}