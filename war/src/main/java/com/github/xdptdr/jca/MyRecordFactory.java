package com.github.xdptdr.jca;

import javax.resource.ResourceException;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.RecordFactory;

public class MyRecordFactory implements RecordFactory {

	private MappedRecord mappedRecord = new MyMappedRecord();
	private IndexedRecord indexedRecord = new MyIndexedRecord();

	@Override
	public MappedRecord createMappedRecord(String recordName) throws ResourceException {
		return mappedRecord ;
	}

	@Override
	public IndexedRecord createIndexedRecord(String recordName) throws ResourceException {
		return indexedRecord;
	}

}
