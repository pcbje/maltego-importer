package com.pcbje.maltegoimporter.model.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.pcbje.maltegoimporter.model.PropertyModel;
import com.pcbje.maltegoimporter.model.impl.MaltegoEntityDefinition;

public class MaltegoNodeEntityDefinitionTest {
	MaltegoEntityDefinition type;

	@Before
	public void init() {
		type = new MaltegoEntityDefinition();
	}

	@Test
	public void testTypeDesktopComputer() {
		Map<String, PropertyModel> props = type
				.getProperties("DesktopComputer");

		assertEquals(1, props.size());
		assertTrue(props.get("device").isLabelProperty());
		assertEquals("Device", props.get("device").getDisplayName());
		assertEquals("string", props.get("device").getType());
	}

	@Test
	public void testTypeDevice() {
		Map<String, PropertyModel> props = type.getProperties("Device");

		assertEquals(1, props.size());
		assertTrue(props.get("device").isLabelProperty());
		assertEquals("Device", props.get("device").getDisplayName());
		assertEquals("string", props.get("device").getType());
	}

	@Test
	public void testTypeMobileComputer() {
		Map<String, PropertyModel> props = type.getProperties("MobileComputer");

		assertEquals(1, props.size());
		assertTrue(props.get("device").isLabelProperty());
		assertEquals("Device", props.get("device").getDisplayName());
		assertEquals("string", props.get("device").getType());
	}

	@Test
	public void testTypeMobilePhone() {
		Map<String, PropertyModel> props = type.getProperties("MobilePhone");

		assertEquals(1, props.size());
		assertTrue(props.get("device").isLabelProperty());
		assertEquals("Device", props.get("device").getDisplayName());
		assertEquals("string", props.get("device").getType());
	}

	@Test
	public void testTypeSmartphone() {
		Map<String, PropertyModel> props = type.getProperties("Smartphone");

		assertEquals(1, props.size());
		assertTrue(props.get("device").isLabelProperty());
		assertEquals("Device", props.get("device").getDisplayName());
		assertEquals("string", props.get("device").getType());
	}

	@Test
	public void testTypeConversationEmail() {
		Map<String, PropertyModel> props = type
				.getProperties("ConversationEmail");

		assertEquals(4, props.size());
		assertEquals(true, props.get("title").isLabelProperty());
		assertEquals("Title", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("email.recipients").isLabelProperty());
		assertEquals("Recipient Emails", props.get("email.recipients")
				.getDisplayName());
		assertEquals("string[]", props.get("email.recipients").getType());

		assertEquals(false, props.get("email").isLabelProperty());
		assertEquals("Sender Email", props.get("email").getDisplayName());
		assertEquals("string", props.get("email").getType());

		assertEquals(false, props.get("people").isLabelProperty());
		assertEquals("People", props.get("people").getDisplayName());
		assertEquals("string[]", props.get("people").getType());
	}

	@Test
	public void testTypeConversationPhone() {
		Map<String, PropertyModel> props = type
				.getProperties("ConversationPhone");

		assertEquals(6, props.size());

		assertEquals(true, props.get("title").isLabelProperty());
		assertEquals("Title", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("phonenumber.caller").isLabelProperty());
		assertEquals("Caller Number", props.get("phonenumber.caller")
				.getDisplayName());
		assertEquals("string", props.get("phonenumber.caller").getType());

		assertEquals(false, props.get("phonenumber.callee").isLabelProperty());
		assertEquals("Callee Number", props.get("phonenumber.callee")
				.getDisplayName());
		assertEquals("string", props.get("phonenumber.callee").getType());

		assertEquals(false, props.get("people").isLabelProperty());
		assertEquals("People", props.get("people").getDisplayName());
		assertEquals("string[]", props.get("people").getType());

		assertEquals(false, props.get("duration").isLabelProperty());
		assertEquals("Duration", props.get("duration").getDisplayName());
		assertEquals("timespan", props.get("duration").getType());

		assertEquals(false, props.get("starttime").isLabelProperty());
		assertEquals("Start time", props.get("starttime").getDisplayName());
		assertEquals("datetime", props.get("starttime").getType());
	}

	@Test
	public void testTypeIncident() {
		Map<String, PropertyModel> props = type.getProperties("Incident");

		assertEquals(12, props.size());

		assertEquals(true, props.get("title").isLabelProperty());
		assertEquals("Title", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("streetaddress").isLabelProperty());
		assertEquals("Street Address", props.get("streetaddress")
				.getDisplayName());
		assertEquals("string", props.get("streetaddress").getType());

		assertEquals(false, props.get("countrycode").isLabelProperty());
		assertEquals("Country Code", props.get("countrycode").getDisplayName());
		assertEquals("string", props.get("countrycode").getType());

		assertEquals(false, props.get("location.area").isLabelProperty());
		assertEquals("Area", props.get("location.area").getDisplayName());
		assertEquals("string", props.get("location.area").getType());

		assertEquals(false, props.get("location.name").isLabelProperty());
		assertEquals("Name", props.get("location.name").getDisplayName());
		assertEquals("string", props.get("location.name").getType());

		assertEquals(false, props.get("location.areacode").isLabelProperty());
		assertEquals("Area Code", props.get("location.areacode")
				.getDisplayName());
		assertEquals("string", props.get("location.areacode").getType());

		assertEquals(false, props.get("longitude").isLabelProperty());
		assertEquals("Longitude", props.get("longitude").getDisplayName());
		assertEquals("float", props.get("longitude").getType());

		assertEquals(false, props.get("latitude").isLabelProperty());
		assertEquals("Latitude", props.get("latitude").getDisplayName());
		assertEquals("float", props.get("latitude").getType());

		assertEquals(false, props.get("city").isLabelProperty());
		assertEquals("City", props.get("city").getDisplayName());
		assertEquals("string", props.get("city").getType());

		assertEquals(false, props.get("country").isLabelProperty());
		assertEquals("Country", props.get("country").getDisplayName());
		assertEquals("string", props.get("country").getType());

		assertEquals(false, props.get("starttime").isLabelProperty());
		assertEquals("Start Time", props.get("starttime").getDisplayName());
		assertEquals("datetime", props.get("starttime").getType());

		assertEquals(false, props.get("stoptime").isLabelProperty());
		assertEquals("Stop Time", props.get("stoptime").getDisplayName());
		assertEquals("datetime", props.get("stoptime").getType());
	}

	@Test
	public void testTypeMeetingBusiness() {
		Map<String, PropertyModel> props = type
				.getProperties("MeetingBusiness");

		assertEquals(13, props.size());

		assertEquals(true, props.get("title").isLabelProperty());
		assertEquals("Title", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("people").isLabelProperty());
		assertEquals("People", props.get("people").getDisplayName());
		assertEquals("string[]", props.get("people").getType());

		assertEquals(false, props.get("streetaddress").isLabelProperty());
		assertEquals("Street Address", props.get("streetaddress")
				.getDisplayName());
		assertEquals("string", props.get("streetaddress").getType());

		assertEquals(false, props.get("countrycode").isLabelProperty());
		assertEquals("Country Code", props.get("countrycode").getDisplayName());
		assertEquals("string", props.get("countrycode").getType());

		assertEquals(false, props.get("location.area").isLabelProperty());
		assertEquals("Area", props.get("location.area").getDisplayName());
		assertEquals("string", props.get("location.area").getType());

		assertEquals(false, props.get("location.name").isLabelProperty());
		assertEquals("Name", props.get("location.name").getDisplayName());
		assertEquals("string", props.get("location.name").getType());

		assertEquals(false, props.get("location.areacode").isLabelProperty());
		assertEquals("Area Code", props.get("location.areacode")
				.getDisplayName());
		assertEquals("string", props.get("location.areacode").getType());

		assertEquals(false, props.get("longitude").isLabelProperty());
		assertEquals("Longitude", props.get("longitude").getDisplayName());
		assertEquals("float", props.get("longitude").getType());

		assertEquals(false, props.get("latitude").isLabelProperty());
		assertEquals("Latitude", props.get("latitude").getDisplayName());
		assertEquals("float", props.get("latitude").getType());

		assertEquals(false, props.get("city").isLabelProperty());
		assertEquals("City", props.get("city").getDisplayName());
		assertEquals("string", props.get("city").getType());

		assertEquals(false, props.get("country").isLabelProperty());
		assertEquals("Country", props.get("country").getDisplayName());
		assertEquals("string", props.get("country").getType());

		assertEquals(false, props.get("starttime").isLabelProperty());
		assertEquals("Start Time", props.get("starttime").getDisplayName());
		assertEquals("datetime", props.get("starttime").getType());

		assertEquals(false, props.get("stoptime").isLabelProperty());
		assertEquals("Stop Time", props.get("stoptime").getDisplayName());
		assertEquals("datetime", props.get("stoptime").getType());
	}

	@Test
	public void testTypeMeetingSocial() {
		Map<String, PropertyModel> props = type.getProperties("MeetingSocial");

		assertEquals(13, props.size());

		assertEquals(true, props.get("title").isLabelProperty());
		assertEquals("Title", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("people").isLabelProperty());
		assertEquals("People", props.get("people").getDisplayName());
		assertEquals("string[]", props.get("people").getType());

		assertEquals(false, props.get("streetaddress").isLabelProperty());
		assertEquals("Street Address", props.get("streetaddress")
				.getDisplayName());
		assertEquals("string", props.get("streetaddress").getType());

		assertEquals(false, props.get("countrycode").isLabelProperty());
		assertEquals("Country Code", props.get("countrycode").getDisplayName());
		assertEquals("string", props.get("countrycode").getType());

		assertEquals(false, props.get("location.area").isLabelProperty());
		assertEquals("Area", props.get("location.area").getDisplayName());
		assertEquals("string", props.get("location.area").getType());

		assertEquals(false, props.get("location.name").isLabelProperty());
		assertEquals("Name", props.get("location.name").getDisplayName());
		assertEquals("string", props.get("location.name").getType());

		assertEquals(false, props.get("location.areacode").isLabelProperty());
		assertEquals("Area Code", props.get("location.areacode")
				.getDisplayName());
		assertEquals("string", props.get("location.areacode").getType());

		assertEquals(false, props.get("longitude").isLabelProperty());
		assertEquals("Longitude", props.get("longitude").getDisplayName());
		assertEquals("float", props.get("longitude").getType());

		assertEquals(false, props.get("latitude").isLabelProperty());
		assertEquals("Latitude", props.get("latitude").getDisplayName());
		assertEquals("float", props.get("latitude").getType());

		assertEquals(false, props.get("city").isLabelProperty());
		assertEquals("City", props.get("city").getDisplayName());
		assertEquals("string", props.get("city").getType());

		assertEquals(false, props.get("country").isLabelProperty());
		assertEquals("Country", props.get("country").getDisplayName());
		assertEquals("string", props.get("country").getType());

		assertEquals(false, props.get("starttime").isLabelProperty());
		assertEquals("Start Time", props.get("starttime").getDisplayName());
		assertEquals("datetime", props.get("starttime").getType());

		assertEquals(false, props.get("stoptime").isLabelProperty());
		assertEquals("Stop Time", props.get("stoptime").getDisplayName());
		assertEquals("datetime", props.get("stoptime").getType());
	}

	@Test
	public void testTypeCompany() {
		Map<String, PropertyModel> props = type.getProperties("Company");

		assertEquals(1, props.size());
		assertTrue(props.get("title").isLabelProperty());
		assertEquals("Name", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());
	}

	@Test
	public void testTypeEducationInstitution() {
		Map<String, PropertyModel> props = type
				.getProperties("EducationInstitution");

		assertEquals(1, props.size());
		assertTrue(props.get("title").isLabelProperty());
		assertEquals("Name", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());
	}

	@Test
	public void testTypeGang() {
		Map<String, PropertyModel> props = type.getProperties("Gang");

		assertEquals(1, props.size());
		assertTrue(props.get("title").isLabelProperty());
		assertEquals("Name", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());
	}

	@Test
	public void testTypeOnlineGroup() {
		Map<String, PropertyModel> props = type.getProperties("OnlineGroup");

		assertEquals(2, props.size());

		assertEquals(true, props.get("title").isLabelProperty());
		assertEquals("Name", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("url").isLabelProperty());
		assertEquals("URL", props.get("url").getDisplayName());
		assertEquals("string", props.get("url").getType());
	}

	@Test
	public void testTypeOrganization() {
		Map<String, PropertyModel> props = type.getProperties("Organization");

		assertEquals(1, props.size());
		assertTrue(props.get("title").isLabelProperty());
		assertEquals("Name", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());
	}

	@Test
	public void testTypePoliticalMovement() {
		Map<String, PropertyModel> props = type
				.getProperties("PoliticalMovement");

		assertEquals(1, props.size());
		assertTrue(props.get("title").isLabelProperty());
		assertEquals("Name", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());
	}

	@Test
	public void testTypeReligiousGroup() {
		Map<String, PropertyModel> props = type.getProperties("ReligiousGroup");

		assertEquals(1, props.size());
		assertTrue(props.get("title").isLabelProperty());
		assertEquals("Name", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());
	}

	@Test
	public void testTypeAS() {
		Map<String, PropertyModel> props = type.getProperties("AS");

		assertEquals(1, props.size());
		assertTrue(props.get("as.number").isLabelProperty());
		assertEquals("AS Number", props.get("as.number").getDisplayName());
		assertEquals("string", props.get("as.number").getType());
	}

	@Test
	public void testTypeDNSName() {
		Map<String, PropertyModel> props = type.getProperties("DNSName");

		assertEquals(1, props.size());
		assertTrue(props.get("fqdn").isLabelProperty());
		assertEquals("DNS Name", props.get("fqdn").getDisplayName());
		assertEquals("string", props.get("fqdn").getType());
	}

	@Test
	public void testTypeDomain() {
		Map<String, PropertyModel> props = type.getProperties("Domain");

		assertEquals(2, props.size());
		assertEquals(true, props.get("fqdn").isLabelProperty());
		assertEquals("DNS Name", props.get("fqdn").getDisplayName());
		assertEquals("string", props.get("fqdn").getType());

		assertEquals(false, props.get("whois-info").isLabelProperty());
		assertEquals("WHOIS Info", props.get("whois-info").getDisplayName());
		assertEquals("string", props.get("whois-info").getType());
	}

	@Test
	public void testTypeIPv4Address() {
		Map<String, PropertyModel> props = type.getProperties("IPv4Address");

		assertEquals(2, props.size());
		assertEquals(true, props.get("ipv4-address").isLabelProperty());
		assertEquals("IP Address", props.get("ipv4-address").getDisplayName());
		assertEquals("string", props.get("ipv4-address").getType());

		assertEquals(false, props.get("ipaddress.internal").isLabelProperty());
		assertEquals("Internal", props.get("ipaddress.internal")
				.getDisplayName());
		assertEquals("boolean", props.get("ipaddress.internal").getType());
	}

	@Test
	public void testTypeMXRecord() {
		Map<String, PropertyModel> props = type.getProperties("MXRecord");

		assertEquals(2, props.size());
		assertEquals(true, props.get("fqdn").isLabelProperty());
		assertEquals("MX Record", props.get("fqdn").getDisplayName());
		assertEquals("string", props.get("fqdn").getType());

		assertEquals(false, props.get("mxrecord.priority").isLabelProperty());
		assertEquals("Priority", props.get("mxrecord.priority")
				.getDisplayName());
		assertEquals("int", props.get("mxrecord.priority").getType());
	}

	@Test
	public void testTypeNSRecord() {
		Map<String, PropertyModel> props = type.getProperties("NSRecord");

		assertEquals(1, props.size());
		assertEquals(true, props.get("fqdn").isLabelProperty());
		assertEquals("NS Record", props.get("fqdn").getDisplayName());
		assertEquals("string", props.get("fqdn").getType());
	}

	@Test
	public void testTypeNetblock() {
		Map<String, PropertyModel> props = type.getProperties("Netblock");

		assertEquals(1, props.size());
		assertEquals(true, props.get("ipv4-range").isLabelProperty());
		assertEquals("IP Range", props.get("ipv4-range").getDisplayName());
		assertEquals("string", props.get("ipv4-range").getType());
	}

	@Test
	public void testTypeURL() {
		Map<String, PropertyModel> props = type.getProperties("URL");

		assertEquals(3, props.size());
		assertEquals(true, props.get("url").isLabelProperty());
		assertEquals("URL", props.get("url").getDisplayName());
		assertEquals("url", props.get("url").getType());

		assertEquals(false, props.get("title").isLabelProperty());
		assertEquals("Title", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("short-title").isLabelProperty());
		assertEquals("Short title", props.get("short-title").getDisplayName());
		assertEquals("string", props.get("short-title").getType());
	}

	@Test
	public void testTypeWebsite() {
		Map<String, PropertyModel> props = type.getProperties("Website");

		assertEquals(3, props.size());
		assertEquals(true, props.get("fqdn").isLabelProperty());
		assertEquals("Website", props.get("fqdn").getDisplayName());
		assertEquals("string", props.get("fqdn").getType());

		assertEquals(false, props.get("ports").isLabelProperty());
		assertEquals("Ports", props.get("ports").getDisplayName());
		assertEquals("int[]", props.get("ports").getType());

		assertEquals(false, props.get("website.ssl-enabled").isLabelProperty());
		assertEquals("SSL Enabled", props.get("website.ssl-enabled")
				.getDisplayName());
		assertEquals("boolean", props.get("website.ssl-enabled").getType());
	}

	@Test
	public void testLocationTypes() {
		String[] types = new String[] { "Airport", "Church", "City", "Country",
				"CrimeScene", "Harbor", "Home", "Location", "Office", "Prison",
				"Region", "Shop", "TrainStation" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties(typeStr);

			assertEquals(9, props.size());

			assertEquals(true, props.get("location.name").isLabelProperty());
			assertEquals("Name", props.get("location.name").getDisplayName());
			assertEquals("string", props.get("location.name").getType());

			assertEquals(false, props.get("streetaddress").isLabelProperty());
			assertEquals("Street Address", props.get("streetaddress")
					.getDisplayName());
			assertEquals("string", props.get("streetaddress").getType());

			assertEquals(false, props.get("countrycode").isLabelProperty());
			assertEquals("Country Code", props.get("countrycode")
					.getDisplayName());
			assertEquals("string", props.get("countrycode").getType());

			assertEquals(false, props.get("location.area").isLabelProperty());
			assertEquals("Area", props.get("location.area").getDisplayName());
			assertEquals("string", props.get("location.area").getType());

			assertEquals(false, props.get("location.areacode")
					.isLabelProperty());
			assertEquals("Area Code", props.get("location.areacode")
					.getDisplayName());
			assertEquals("string", props.get("location.areacode").getType());

			assertEquals(false, props.get("longitude").isLabelProperty());
			assertEquals("Longitude", props.get("longitude").getDisplayName());
			assertEquals("float", props.get("longitude").getType());

			assertEquals(false, props.get("latitude").isLabelProperty());
			assertEquals("Latitude", props.get("latitude").getDisplayName());
			assertEquals("float", props.get("latitude").getType());

			assertEquals(false, props.get("city").isLabelProperty());
			assertEquals("City", props.get("city").getDisplayName());
			assertEquals("string", props.get("city").getType());

			assertEquals(false, props.get("country").isLabelProperty());
			assertEquals("Country", props.get("country").getDisplayName());
			assertEquals("string", props.get("country").getType());
		}
	}

	@Test
	public void testPeopleTypes() {
		String[] types = new String[] { "BusinessLeader", "Businessman",
				"Child", "DrugDealer", "Female", "GangLeader", "GangMember",
				"GovernmentOfficial", "Judge", "LawOfficer", "Lawyer", "Male",
				"MilitaryOfficer", "SexOffender", "Terrorist",
				"TerroristLeader", "Unsub" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties(typeStr);

			assertEquals(3, props.size());

			assertEquals(true, props.get("person.fullname").isLabelProperty());
			assertFalse(props.get("person.firstnames").isLabelProperty());
			assertFalse(props.get("person.surname").isLabelProperty());
		}
	}

	@Test
	public void testTypeAlias() {
		Map<String, PropertyModel> props = type.getProperties("Alias");

		assertEquals(1, props.size());
		assertEquals(true, props.get("alias").isLabelProperty());
		assertEquals("Alias", props.get("alias").getDisplayName());
		assertEquals("string", props.get("alias").getType());
	}

	@Test
	public void testTypeDocument() {
		Map<String, PropertyModel> props = type.getProperties("Document");

		assertEquals(3, props.size());
		assertEquals(true, props.get("title").isLabelProperty());
		assertEquals("Title", props.get("title").getDisplayName());
		assertEquals("string", props.get("title").getType());

		assertEquals(false, props.get("document.meta-data").isLabelProperty());
		assertEquals("Meta-Data", props.get("document.meta-data")
				.getDisplayName());
		assertEquals("string", props.get("document.meta-data").getType());

		assertEquals(false, props.get("url").isLabelProperty());
		assertEquals("URL", props.get("url").getDisplayName());
		assertEquals("url", props.get("url").getType());
	}

	@Test
	public void testTypeEmailAddress() {
		Map<String, PropertyModel> props = type.getProperties("EmailAddress");

		assertEquals(1, props.size());
		assertEquals(true, props.get("email").isLabelProperty());
		assertEquals("Email Address", props.get("email").getDisplayName());
		assertEquals("string", props.get("email").getType());
	}

	@Test
	public void testTypeImage() {
		Map<String, PropertyModel> props = type.getProperties("Image");

		assertEquals(2, props.size());
		assertEquals(true, props.get("description").isLabelProperty());
		assertEquals("Description", props.get("description").getDisplayName());
		assertEquals("string", props.get("description").getType());

		assertEquals(false, props.get("url").isLabelProperty());
		assertEquals("URL", props.get("url").getDisplayName());
		assertEquals("url", props.get("url").getType());
	}

	@Test
	public void testTypePerson() {
		Map<String, PropertyModel> props = type.getProperties("Person");

		assertEquals(3, props.size());
		assertEquals(true, props.get("person.fullname").isLabelProperty());
		assertEquals("Full Name", props.get("person.fullname").getDisplayName());
		assertEquals("string", props.get("person.fullname").getType());

		assertFalse(props.get("person.firstnames").isLabelProperty());
		assertEquals("First Names", props.get("person.firstnames")
				.getDisplayName());
		assertEquals("string", props.get("person.firstnames").getType());

		assertFalse(props.get("person.surname").isLabelProperty());
		assertEquals("Surname", props.get("person.surname").getDisplayName());
		assertEquals("string", props.get("person.surname").getType());
	}

	@Test
	public void testPhoneNumberTypes() {
		String[] types = new String[] { "PhoneNumber", "PhoneNumberMobile",
				"PhoneNumberOffice", "PhoneNumberResidential" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties(typeStr);

			assertEquals(5, props.size());
			assertEquals(true, props.get("phonenumber").isLabelProperty());
			assertEquals("Phone Number", props.get("phonenumber")
					.getDisplayName());
			assertEquals("string", props.get("phonenumber").getType());

			assertEquals(false, props.get("phonenumber.citycode")
					.isLabelProperty());
			assertEquals("City Code", props.get("phonenumber.citycode")
					.getDisplayName());
			assertEquals("string", props.get("phonenumber.citycode").getType());

			assertEquals(false, props.get("phonenumber.countrycode")
					.isLabelProperty());
			assertEquals("Country Code", props.get("phonenumber.countrycode")
					.getDisplayName());
			assertEquals("string", props.get("phonenumber.countrycode")
					.getType());

			assertEquals(false, props.get("phonenumber.areacode")
					.isLabelProperty());
			assertEquals("Area Code", props.get("phonenumber.areacode")
					.getDisplayName());
			assertEquals("string", props.get("phonenumber.areacode").getType());

			assertEquals(false, props.get("phonenumber.lastnumbers")
					.isLabelProperty());
			assertEquals("Last Digits", props.get("phonenumber.lastnumbers")
					.getDisplayName());
			assertEquals("string", props.get("phonenumber.lastnumbers")
					.getType());
		}
	}

	@Test
	public void testTypePhrase() {
		Map<String, PropertyModel> props = type.getProperties("Phrase");

		assertEquals(1, props.size());
		assertEquals(true, props.get("text").isLabelProperty());
		assertEquals("Text", props.get("text").getDisplayName());
		assertEquals("string", props.get("text").getType());
	}

	@Test
	public void testTypeAffiliationFacebook() {
		Map<String, PropertyModel> props = type
				.getProperties("affiliation.Facebook");

		assertEquals(4, props.size());
		assertEquals(true, props.get("person.name").isLabelProperty());
		assertEquals("Name", props.get("person.name").getDisplayName());
		assertEquals("string", props.get("person.name").getType());

		assertEquals(false, props.get("affiliation.profile-url")
				.isLabelProperty());
		assertEquals("Profile URL", props.get("affiliation.profile-url")
				.getDisplayName());
		assertEquals("string", props.get("affiliation.profile-url").getType());

		assertEquals(false, props.get("affiliation.network").isLabelProperty());
		assertEquals("Network", props.get("affiliation.network")
				.getDisplayName());
		assertEquals("string", props.get("affiliation.network").getType());

		assertEquals(false, props.get("affiliation.uid").isLabelProperty());
		assertEquals("UID", props.get("affiliation.uid").getDisplayName());
		assertEquals("string", props.get("affiliation.uid").getType());
	}

	@Test
	public void testTypeAffiliationLinkedIn() {
		Map<String, PropertyModel> props = type
				.getProperties("affiliation.LinkedIn");

		assertEquals(4, props.size());
		assertEquals(true, props.get("person.name").isLabelProperty());
		assertEquals("Name", props.get("person.name").getDisplayName());
		assertEquals("string", props.get("person.name").getType());

		assertEquals(false, props.get("affiliation.profile-url")
				.isLabelProperty());
		assertEquals("Profile URL", props.get("affiliation.profile-url")
				.getDisplayName());
		assertEquals("string", props.get("affiliation.profile-url").getType());

		assertEquals(false, props.get("affiliation.network").isLabelProperty());
		assertEquals("Network", props.get("affiliation.network")
				.getDisplayName());
		assertEquals("string", props.get("affiliation.network").getType());

		assertEquals(false, props.get("affiliation.uid").isLabelProperty());
		assertEquals("UID", props.get("affiliation.uid").getDisplayName());
		assertEquals("string", props.get("affiliation.uid").getType());
	}

	@Test
	public void testTypeAffiliationTwitter() {
		Map<String, PropertyModel> props = type
				.getProperties("affiliation.Twitter");

		assertEquals(8, props.size());
		assertEquals(true, props.get("person.name").isLabelProperty());
		assertEquals("Name", props.get("person.name").getDisplayName());
		assertEquals("string", props.get("person.name").getType());

		assertEquals(false, props.get("person.fullname").isLabelProperty());
		assertEquals("Real Name", props.get("person.fullname").getDisplayName());
		assertEquals("string", props.get("person.fullname").getType());

		assertEquals(false, props.get("twitter.number").isLabelProperty());
		assertEquals("Twitter Number", props.get("twitter.number")
				.getDisplayName());
		assertEquals("int", props.get("twitter.number").getType());

		assertEquals(false, props.get("affiliation.profile-url")
				.isLabelProperty());
		assertEquals("Profile URL", props.get("affiliation.profile-url")
				.getDisplayName());
		assertEquals("string", props.get("affiliation.profile-url").getType());

		assertEquals(false, props.get("twitter.screen-name").isLabelProperty());
		assertEquals("Screen Name", props.get("twitter.screen-name")
				.getDisplayName());
		assertEquals("string", props.get("twitter.screen-name").getType());

		assertEquals(false, props.get("twitter.friendcount").isLabelProperty());
		assertEquals("Friend Count", props.get("twitter.friendcount")
				.getDisplayName());
		assertEquals("int", props.get("twitter.friendcount").getType());

		assertEquals(false, props.get("affiliation.network").isLabelProperty());
		assertEquals("Network", props.get("affiliation.network")
				.getDisplayName());
		assertEquals("string", props.get("affiliation.network").getType());

		assertEquals(false, props.get("affiliation.uid").isLabelProperty());
		assertEquals("UID", props.get("affiliation.uid").getDisplayName());
		assertEquals("string", props.get("affiliation.uid").getType());
	}

	@Test
	public void testTypeBankAccount() {
		Map<String, PropertyModel> props = type.getProperties("BankAccount");

		assertEquals(3, props.size());
		assertEquals(true, props.get("bank.accnumber").isLabelProperty());
		assertEquals("Account Number", props.get("bank.accnumber")
				.getDisplayName());
		assertEquals("string", props.get("bank.accnumber").getType());

		assertEquals(false, props.get("bank.branch").isLabelProperty());
		assertEquals("Branch Code", props.get("bank.branch").getDisplayName());
		assertEquals("string", props.get("bank.branch").getType());

		assertEquals(false, props.get("bank.name").isLabelProperty());
		assertEquals("Bank", props.get("bank.name").getDisplayName());
		assertEquals("string", props.get("bank.name").getType());
	}

	@Test
	public void testTypeFlightNumber() {
		Map<String, PropertyModel> props = type.getProperties("FlightNumber");

		assertEquals(4, props.size());
		assertEquals(true, props.get("flight.id").isLabelProperty());
		assertEquals("Flight ID", props.get("flight.id").getDisplayName());
		assertEquals("string", props.get("flight.id").getType());

		assertEquals(false, props.get("flight.airline").isLabelProperty());
		assertEquals("Airline", props.get("flight.airline").getDisplayName());
		assertEquals("string", props.get("flight.airline").getType());

		assertEquals(false, props.get("flight.date").isLabelProperty());
		assertEquals("Date", props.get("flight.date").getDisplayName());
		assertEquals("date", props.get("flight.date").getType());

		assertEquals(false, props.get("flight.number").isLabelProperty());
		assertEquals("Flight Number", props.get("flight.number")
				.getDisplayName());
		assertEquals("string", props.get("flight.number").getType());
	}

	@Test
	public void testTypeIdentificationNumber() {
		Map<String, PropertyModel> props = type
				.getProperties("IdentificationNumber");

		assertEquals(1, props.size());
		assertEquals(true, props.get("identification.number").isLabelProperty());
		assertEquals("Number", props.get("identification.number")
				.getDisplayName());
		assertEquals("string", props.get("identification.number").getType());
	}

	@Test
	public void testTypeMacAddress() {
		Map<String, PropertyModel> props = type.getProperties("MacAddress");

		assertEquals(1, props.size());
		assertEquals(true, props.get("macaddress").isLabelProperty());
		assertEquals("MAC Address", props.get("macaddress").getDisplayName());
		assertEquals("string", props.get("macaddress").getType());
	}

	@Test
	public void testTypePassportNumber() {
		Map<String, PropertyModel> props = type.getProperties("PassportNumber");

		assertEquals(1, props.size());
		assertEquals(true, props.get("identification.number").isLabelProperty());
		assertEquals("Number", props.get("identification.number")
				.getDisplayName());
		assertEquals("string", props.get("identification.number").getType());
	}

	@Test
	public void testTypeVehicleRegistration() {
		Map<String, PropertyModel> props = type
				.getProperties("VehicleRegistration");

		assertEquals(1, props.size());
		assertEquals(true, props.get("vehicle.registration").isLabelProperty());
		assertEquals("Registration Number", props.get("vehicle.registration")
				.getDisplayName());
		assertEquals("string", props.get("vehicle.registration").getType());
	}

	@Test
	public void testTypeVinNumber() {
		Map<String, PropertyModel> props = type.getProperties("VinNumber");

		assertEquals(1, props.size());
		assertEquals(true, props.get("vinnumber").isLabelProperty());
		assertEquals("VIN Number", props.get("vinnumber").getDisplayName());
		assertEquals("string", props.get("vinnumber").getType());
	}

	@Test
	public void testTransportationTypes() {
		String[] types = new String[] { "Bike", "Boat", "Bus", "Car", "Plane",
				"Train" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties(typeStr);

			assertEquals(3, props.size());
			assertEquals(true, props.get("transport.name").isLabelProperty());
			assertEquals("Name", props.get("transport.name").getDisplayName());
			assertEquals("string", props.get("transport.name").getType());

			assertEquals(false, props.get("transport.make").isLabelProperty());
			assertEquals("Make", props.get("transport.make").getDisplayName());
			assertEquals("string", props.get("transport.make").getType());

			assertEquals(false, props.get("transport.model").isLabelProperty());
			assertEquals("Model", props.get("transport.model").getDisplayName());
			assertEquals("string", props.get("transport.model").getType());
		}
	}

	@Test
	public void testWeaponTypes() {
		String[] types = new String[] { "Ammunition", "BioWeapon", "Blade",
				"ChemicalWeapon", "Explosive", "Gun", "IED", "Missile",
				"NuclearWeapon" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties(typeStr);

			assertEquals(1, props.size());
			assertEquals(true, props.get("weapon.type").isLabelProperty());
			assertEquals("Type", props.get("weapon.type").getDisplayName());
			assertEquals("string", props.get("weapon.type").getType());
		}
	}
}
