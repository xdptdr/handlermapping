package com.github.xdptdr.jca;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.resource.cci.IndexedRecord;

public class MyIndexedRecord extends MyRecord implements IndexedRecord {

	private static final long serialVersionUID = 1L;

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return null;
	}

	@Override
	public boolean add(Object e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(@SuppressWarnings("rawtypes") Collection c) {
		return false;
	}

	@Override
	public boolean addAll(@SuppressWarnings("rawtypes") Collection c) {
		return false;
	}

	@Override
	public boolean addAll(int index, @SuppressWarnings("rawtypes") Collection c) {
		return false;
	}

	@Override
	public boolean removeAll(@SuppressWarnings("rawtypes") Collection c) {
		return false;
	}

	@Override
	public boolean retainAll(@SuppressWarnings("rawtypes") Collection c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public Object get(int index) {
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		return null;
	}

	@Override
	public void add(int index, Object element) {

	}

	@Override
	public Object remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ListIterator listIterator() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ListIterator listIterator(int index) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List subList(int fromIndex, int toIndex) {
		return null;
	}
}
