package com.progresssoft.ClusteredDataWarehouse.test.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileEmptyData implements MultipartFile {

	String originalFileName;

	long size;

	public MultipartFileEmptyData(String originalFileName, long size) {
		this.originalFileName = originalFileName;
		this.size = size;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getOriginalFilename() {
		return originalFileName;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {

	}

}
