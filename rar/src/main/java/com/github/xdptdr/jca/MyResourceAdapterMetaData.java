package com.github.xdptdr.jca;

import javax.resource.cci.ResourceAdapterMetaData;

public class MyResourceAdapterMetaData implements ResourceAdapterMetaData {

	private String adapterVersion = "adapterVersion";
	private String adapterVendorName = "adapterVendorName";
	private String adapterName = "adapterName";
	private String adapterShortDescription = "adapterShortDescription";
	private String specVersion = "specVersion";
	private String[] interactionSpecsSupported = new String[] { "interactionSpecsSupported" };

	@Override
	public String getAdapterVersion() {
		return adapterVersion;
	}

	@Override
	public String getAdapterVendorName() {
		return adapterVendorName;
	}

	@Override
	public String getAdapterName() {
		return adapterName;
	}

	@Override
	public String getAdapterShortDescription() {
		return adapterShortDescription;
	}

	@Override
	public String getSpecVersion() {
		return specVersion;
	}

	@Override
	public String[] getInteractionSpecsSupported() {
		return interactionSpecsSupported;
	}

	@Override
	public boolean supportsExecuteWithInputAndOutputRecord() {
		return false;
	}

	@Override
	public boolean supportsExecuteWithInputRecordOnly() {
		return false;
	}

	@Override
	public boolean supportsLocalTransactionDemarcation() {
		return false;
	}

}
