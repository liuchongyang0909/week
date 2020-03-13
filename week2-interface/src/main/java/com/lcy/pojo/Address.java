package com.lcy.pojo;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -7773244763254598006L;
	private Integer did;
	private String dname;
	private Integer number;
	private String testdate;
	private String people;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getTestdate() {
		return testdate;
	}
	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Address [did=" + did + ", dname=" + dname + ", number=" + number + ", testdate=" + testdate
				+ ", people=" + people + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer did, String dname, Integer number, String testdate, String people) {
		super();
		this.did = did;
		this.dname = dname;
		this.number = number;
		this.testdate = testdate;
		this.people = people;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((did == null) ? 0 : did.hashCode());
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((people == null) ? 0 : people.hashCode());
		result = prime * result + ((testdate == null) ? 0 : testdate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (did == null) {
			if (other.did != null)
				return false;
		} else if (!did.equals(other.did))
			return false;
		if (dname == null) {
			if (other.dname != null)
				return false;
		} else if (!dname.equals(other.dname))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (people == null) {
			if (other.people != null)
				return false;
		} else if (!people.equals(other.people))
			return false;
		if (testdate == null) {
			if (other.testdate != null)
				return false;
		} else if (!testdate.equals(other.testdate))
			return false;
		return true;
	}
}
