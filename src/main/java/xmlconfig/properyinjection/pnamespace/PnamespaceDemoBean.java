package xmlconfig.properyinjection.pnamespace;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import soundsystem.CompactDisk;

/**
 * 
 * @author amit this bean is to demonstrate DI using p:namespace
 */

public class PnamespaceDemoBean implements InitializingBean {

	private CompactDisk compactDisk;
	private String sampleString;
	private List<String> sampleList;

	public CompactDisk getCompactDisk() {
		return compactDisk;
	}

	public void setCompactDisk(CompactDisk compactDisk) {
		this.compactDisk = compactDisk;
	}

	public String getSampleString() {
		return sampleString;
	}

	public void setSampleString(String sampleString) {
		this.sampleString = sampleString;
	}

	public List<String> getSampleList() {
		return sampleList;
	}

	public void setSampleList(List<String> sampleList) {
		this.sampleList = sampleList;
	}

	public void validateBean() {
		if (compactDisk != null && sampleList != null && sampleList.size() > 0 && sampleString != null) {
			System.out.println("PnamespaceDemoBean Bean initialized successfully");
		} else {
			System.out.println("Something went wrong while initializing PnamespaceDemoBean bean");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inisde afterPropertiesSet of PnamespaceDemoBean");
	}
}
