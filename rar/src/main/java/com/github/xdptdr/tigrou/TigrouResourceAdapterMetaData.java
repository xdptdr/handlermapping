package com.github.xdptdr.tigrou;

import javax.resource.cci.ResourceAdapterMetaData;

public class TigrouResourceAdapterMetaData implements ResourceAdapterMetaData {

	@Override
	public String getAdapterVersion() {
		return "1.0";
	}

	@Override
	public String getAdapterVendorName() {
		return "com.github.xdptdr";
	}

	@Override
	public String getAdapterName() {
		return "tigrou";
	}

	@Override
	public String getAdapterShortDescription() {
		return "sample";
	}

	@Override
	public String getSpecVersion() {
		return "1.7";
	}

	@Override
	public String[] getInteractionSpecsSupported() {
		return new String[]{"com.github.xdptdr.tigrou.TigrouInteractionSpec"};
	}

	@Override
	public boolean supportsExecuteWithInputAndOutputRecord() {
		return false;
	}

	@Override
	public boolean supportsExecuteWithInputRecordOnly() {
		return true;
	}

	@Override
	public boolean supportsLocalTransactionDemarcation() {
		return false;
	}

}
