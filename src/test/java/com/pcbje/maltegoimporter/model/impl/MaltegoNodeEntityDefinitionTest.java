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
				.getProperties("maltego.DesktopComputer");

		assertEquals(1, props.size());
		assertTrue(props.get("Device").isLabelProperty());
		assertEquals("Device", props.get("Device").getDisplayName());
		assertEquals("string", props.get("Device").getType());
	}

	@Test
	public void testTypeDevice() {
		Map<String, PropertyModel> props = type.getProperties("maltego.Device");

		assertEquals(1, props.size());
		assertTrue(props.get("Device").isLabelProperty());
		assertEquals("Device", props.get("Device").getDisplayName());
		assertEquals("string", props.get("Device").getType());
	}

	@Test
	public void testTypeMobileComputer() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.MobileComputer");

		assertEquals(1, props.size());
		assertTrue(props.get("Device").isLabelProperty());
		assertEquals("Device", props.get("Device").getDisplayName());
		assertEquals("string", props.get("Device").getType());
	}

	@Test
	public void testTypeMobilePhone() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.MobilePhone");

		assertEquals(1, props.size());
		assertTrue(props.get("Device").isLabelProperty());
		assertEquals("Device", props.get("Device").getDisplayName());
		assertEquals("string", props.get("Device").getType());
	}

	@Test
	public void testTypeSmartphone() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.Smartphone");

		assertEquals(1, props.size());
		assertTrue(props.get("Device").isLabelProperty());
		assertEquals("Device", props.get("Device").getDisplayName());
		assertEquals("string", props.get("Device").getType());
	}

	@Test
	public void testTypeConversationEmail() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.ConversationEmail");

		assertEquals(4, props.size());
		assertEquals(true, props.get("Title").isLabelProperty());
		assertEquals("Title", props.get("Title").getDisplayName());
		assertEquals("string", props.get("Title").getType());

		assertEquals(false, props.get("Recipient Emails").isLabelProperty());
		assertEquals("Recipient Emails", props.get("Recipient Emails")
				.getDisplayName());
		assertEquals("string[]", props.get("Recipient Emails").getType());

		assertEquals(false, props.get("Sender Email").isLabelProperty());
		assertEquals("Sender Email", props.get("Sender Email").getDisplayName());
		assertEquals("string", props.get("Sender Email").getType());

		assertEquals(false, props.get("People").isLabelProperty());
		assertEquals("People", props.get("People").getDisplayName());
		assertEquals("string[]", props.get("People").getType());
	}

	@Test
	public void testTypeConversationPhone() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.ConversationPhone");

		assertEquals(6, props.size());

		assertEquals(true, props.get("Title").isLabelProperty());
		assertEquals("Title", props.get("Title").getDisplayName());
		assertEquals("string", props.get("Title").getType());

		assertEquals(false, props.get("Caller Number").isLabelProperty());
		assertEquals("Caller Number", props.get("Caller Number")
				.getDisplayName());
		assertEquals("string", props.get("Caller Number").getType());

		assertEquals(false, props.get("Callee Number").isLabelProperty());
		assertEquals("Callee Number", props.get("Callee Number")
				.getDisplayName());
		assertEquals("string", props.get("Callee Number").getType());

		assertEquals(false, props.get("People").isLabelProperty());
		assertEquals("People", props.get("People").getDisplayName());
		assertEquals("string[]", props.get("People").getType());

		assertEquals(false, props.get("Duration").isLabelProperty());
		assertEquals("Duration", props.get("Duration").getDisplayName());
		assertEquals("timespan", props.get("Duration").getType());

		assertEquals(false, props.get("Start time").isLabelProperty());
		assertEquals("Start time", props.get("Start time").getDisplayName());
		assertEquals("datetime", props.get("Start time").getType());
	}

	@Test
	public void testTypeIncident() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.Incident");

		assertEquals(12, props.size());

		assertEquals(true, props.get("Title").isLabelProperty());
		assertEquals("Title", props.get("Title").getDisplayName());
		assertEquals("string", props.get("Title").getType());

		assertEquals(false, props.get("Street Address").isLabelProperty());
		assertEquals("Street Address", props.get("Street Address")
				.getDisplayName());
		assertEquals("string", props.get("Street Address").getType());

		assertEquals(false, props.get("Country Code").isLabelProperty());
		assertEquals("Country Code", props.get("Country Code").getDisplayName());
		assertEquals("string", props.get("Country Code").getType());

		assertEquals(false, props.get("Area").isLabelProperty());
		assertEquals("Area", props.get("Area").getDisplayName());
		assertEquals("string", props.get("Area").getType());

		assertEquals(false, props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());

		assertEquals(false, props.get("Area Code").isLabelProperty());
		assertEquals("Area Code", props.get("Area Code").getDisplayName());
		assertEquals("string", props.get("Area Code").getType());

		assertEquals(false, props.get("Longitude").isLabelProperty());
		assertEquals("Longitude", props.get("Longitude").getDisplayName());
		assertEquals("float", props.get("Longitude").getType());

		assertEquals(false, props.get("Latitude").isLabelProperty());
		assertEquals("Latitude", props.get("Latitude").getDisplayName());
		assertEquals("float", props.get("Latitude").getType());

		assertEquals(false, props.get("City").isLabelProperty());
		assertEquals("City", props.get("City").getDisplayName());
		assertEquals("string", props.get("City").getType());

		assertEquals(false, props.get("Country").isLabelProperty());
		assertEquals("Country", props.get("Country").getDisplayName());
		assertEquals("string", props.get("Country").getType());

		assertEquals(false, props.get("Start Time").isLabelProperty());
		assertEquals("Start Time", props.get("Start Time").getDisplayName());
		assertEquals("datetime", props.get("Start Time").getType());

		assertEquals(false, props.get("Stop Time").isLabelProperty());
		assertEquals("Stop Time", props.get("Stop Time").getDisplayName());
		assertEquals("datetime", props.get("Stop Time").getType());
	}

	@Test
	public void testTypeMeetingBusiness() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.MeetingBusiness");

		assertEquals(13, props.size());

		assertEquals(true, props.get("Title").isLabelProperty());
		assertEquals("Title", props.get("Title").getDisplayName());
		assertEquals("string", props.get("Title").getType());

		assertEquals(false, props.get("People").isLabelProperty());
		assertEquals("People", props.get("People").getDisplayName());
		assertEquals("string[]", props.get("People").getType());

		assertEquals(false, props.get("Street Address").isLabelProperty());
		assertEquals("Street Address", props.get("Street Address")
				.getDisplayName());
		assertEquals("string", props.get("Street Address").getType());

		assertEquals(false, props.get("Country Code").isLabelProperty());
		assertEquals("Country Code", props.get("Country Code").getDisplayName());
		assertEquals("string", props.get("Country Code").getType());

		assertEquals(false, props.get("Area").isLabelProperty());
		assertEquals("Area", props.get("Area").getDisplayName());
		assertEquals("string", props.get("Area").getType());

		assertEquals(false, props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());

		assertEquals(false, props.get("Area Code").isLabelProperty());
		assertEquals("Area Code", props.get("Area Code").getDisplayName());
		assertEquals("string", props.get("Area Code").getType());

		assertEquals(false, props.get("Longitude").isLabelProperty());
		assertEquals("Longitude", props.get("Longitude").getDisplayName());
		assertEquals("float", props.get("Longitude").getType());

		assertEquals(false, props.get("Latitude").isLabelProperty());
		assertEquals("Latitude", props.get("Latitude").getDisplayName());
		assertEquals("float", props.get("Latitude").getType());

		assertEquals(false, props.get("City").isLabelProperty());
		assertEquals("City", props.get("City").getDisplayName());
		assertEquals("string", props.get("City").getType());

		assertEquals(false, props.get("Country").isLabelProperty());
		assertEquals("Country", props.get("Country").getDisplayName());
		assertEquals("string", props.get("Country").getType());

		assertEquals(false, props.get("Start Time").isLabelProperty());
		assertEquals("Start Time", props.get("Start Time").getDisplayName());
		assertEquals("datetime", props.get("Start Time").getType());

		assertEquals(false, props.get("Stop Time").isLabelProperty());
		assertEquals("Stop Time", props.get("Stop Time").getDisplayName());
		assertEquals("datetime", props.get("Stop Time").getType());
	}

	@Test
	public void testTypeMeetingSocial() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.MeetingSocial");

		assertEquals(13, props.size());

		assertEquals(true, props.get("Title").isLabelProperty());
		assertEquals("Title", props.get("Title").getDisplayName());
		assertEquals("string", props.get("Title").getType());

		assertEquals(false, props.get("People").isLabelProperty());
		assertEquals("People", props.get("People").getDisplayName());
		assertEquals("string[]", props.get("People").getType());

		assertEquals(false, props.get("Street Address").isLabelProperty());
		assertEquals("Street Address", props.get("Street Address")
				.getDisplayName());
		assertEquals("string", props.get("Street Address").getType());

		assertEquals(false, props.get("Country Code").isLabelProperty());
		assertEquals("Country Code", props.get("Country Code").getDisplayName());
		assertEquals("string", props.get("Country Code").getType());

		assertEquals(false, props.get("Area").isLabelProperty());
		assertEquals("Area", props.get("Area").getDisplayName());
		assertEquals("string", props.get("Area").getType());

		assertEquals(false, props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());

		assertEquals(false, props.get("Area Code").isLabelProperty());
		assertEquals("Area Code", props.get("Area Code").getDisplayName());
		assertEquals("string", props.get("Area Code").getType());

		assertEquals(false, props.get("Longitude").isLabelProperty());
		assertEquals("Longitude", props.get("Longitude").getDisplayName());
		assertEquals("float", props.get("Longitude").getType());

		assertEquals(false, props.get("Latitude").isLabelProperty());
		assertEquals("Latitude", props.get("Latitude").getDisplayName());
		assertEquals("float", props.get("Latitude").getType());

		assertEquals(false, props.get("City").isLabelProperty());
		assertEquals("City", props.get("City").getDisplayName());
		assertEquals("string", props.get("City").getType());

		assertEquals(false, props.get("Country").isLabelProperty());
		assertEquals("Country", props.get("Country").getDisplayName());
		assertEquals("string", props.get("Country").getType());

		assertEquals(false, props.get("Start Time").isLabelProperty());
		assertEquals("Start Time", props.get("Start Time").getDisplayName());
		assertEquals("datetime", props.get("Start Time").getType());

		assertEquals(false, props.get("Stop Time").isLabelProperty());
		assertEquals("Stop Time", props.get("Stop Time").getDisplayName());
		assertEquals("datetime", props.get("Stop Time").getType());
	}

	@Test
	public void testTypeCompany() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.Company");

		assertEquals(1, props.size());
		assertTrue(props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());
	}

	@Test
	public void testTypeEducationInstitution() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.EducationInstitution");

		assertEquals(1, props.size());
		assertTrue(props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());
	}

	@Test
	public void testTypeGang() {
		Map<String, PropertyModel> props = type.getProperties("maltego.Gang");

		assertEquals(1, props.size());
		assertTrue(props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());
	}

	@Test
	public void testTypeOnlineGroup() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.OnlineGroup");

		assertEquals(2, props.size());

		assertEquals(true, props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());

		assertEquals(false, props.get("URL").isLabelProperty());
		assertEquals("URL", props.get("URL").getDisplayName());
		assertEquals("string", props.get("URL").getType());
	}

	@Test
	public void testTypeOrganization() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.Organization");

		assertEquals(1, props.size());
		assertTrue(props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());
	}

	@Test
	public void testTypePoliticalMovement() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.PoliticalMovement");

		assertEquals(1, props.size());
		assertTrue(props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());
	}

	@Test
	public void testTypeReligiousGroup() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.ReligiousGroup");

		assertEquals(1, props.size());
		assertTrue(props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());
	}

	@Test
	public void testTypeAS() {
		Map<String, PropertyModel> props = type.getProperties("maltego.AS");

		assertEquals(1, props.size());
		assertTrue(props.get("AS Number").isLabelProperty());
		assertEquals("AS Number", props.get("AS Number").getDisplayName());
		assertEquals("string", props.get("AS Number").getType());
	}

	@Test
	public void testTypeDNSName() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.DNSName");

		assertEquals(1, props.size());
		assertTrue(props.get("DNS Name").isLabelProperty());
		assertEquals("DNS Name", props.get("DNS Name").getDisplayName());
		assertEquals("string", props.get("DNS Name").getType());
	}

	@Test
	public void testTypeDomain() {
		Map<String, PropertyModel> props = type.getProperties("maltego.Domain");

		assertEquals(2, props.size());
		assertEquals(true, props.get("DNS Name").isLabelProperty());
		assertEquals("DNS Name", props.get("DNS Name").getDisplayName());
		assertEquals("string", props.get("DNS Name").getType());

		assertEquals(false, props.get("WHOIS Info").isLabelProperty());
		assertEquals("WHOIS Info", props.get("WHOIS Info").getDisplayName());
		assertEquals("string", props.get("WHOIS Info").getType());
	}

	@Test
	public void testTypeIPv4Address() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.IPv4Address");

		assertEquals(2, props.size());
		assertEquals(true, props.get("IP Address").isLabelProperty());
		assertEquals("IP Address", props.get("IP Address").getDisplayName());
		assertEquals("string", props.get("IP Address").getType());

		assertEquals(false, props.get("Internal").isLabelProperty());
		assertEquals("Internal", props.get("Internal").getDisplayName());
		assertEquals("boolean", props.get("Internal").getType());
	}

	@Test
	public void testTypeMXRecord() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.MXRecord");

		assertEquals(2, props.size());
		assertEquals(true, props.get("MX Record").isLabelProperty());
		assertEquals("MX Record", props.get("MX Record").getDisplayName());
		assertEquals("string", props.get("MX Record").getType());

		assertEquals(false, props.get("Priority").isLabelProperty());
		assertEquals("Priority", props.get("Priority").getDisplayName());
		assertEquals("int", props.get("Priority").getType());
	}

	@Test
	public void testTypeNSRecord() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.NSRecord");

		assertEquals(1, props.size());
		assertEquals(true, props.get("NS Record").isLabelProperty());
		assertEquals("NS Record", props.get("NS Record").getDisplayName());
		assertEquals("string", props.get("NS Record").getType());
	}

	@Test
	public void testTypeNetblock() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.Netblock");

		assertEquals(1, props.size());
		assertEquals(true, props.get("IP Range").isLabelProperty());
		assertEquals("IP Range", props.get("IP Range").getDisplayName());
		assertEquals("string", props.get("IP Range").getType());
	}

	@Test
	public void testTypeURL() {
		Map<String, PropertyModel> props = type.getProperties("maltego.URL");

		assertEquals(3, props.size());
		assertEquals(true, props.get("URL").isLabelProperty());
		assertEquals("URL", props.get("URL").getDisplayName());
		assertEquals("url", props.get("URL").getType());

		assertEquals(false, props.get("Title").isLabelProperty());
		assertEquals("Title", props.get("Title").getDisplayName());
		assertEquals("string", props.get("Title").getType());

		assertEquals(false, props.get("Short title").isLabelProperty());
		assertEquals("Short title", props.get("Short title").getDisplayName());
		assertEquals("string", props.get("Short title").getType());
	}

	@Test
	public void testTypeWebsite() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.Website");

		assertEquals(3, props.size());
		assertEquals(true, props.get("Website").isLabelProperty());
		assertEquals("Website", props.get("Website").getDisplayName());
		assertEquals("string", props.get("Website").getType());

		assertEquals(false, props.get("Ports").isLabelProperty());
		assertEquals("Ports", props.get("Ports").getDisplayName());
		assertEquals("int[]", props.get("Ports").getType());

		assertEquals(false, props.get("SSL Enabled").isLabelProperty());
		assertEquals("SSL Enabled", props.get("SSL Enabled").getDisplayName());
		assertEquals("boolean", props.get("SSL Enabled").getType());
	}

	@Test
	public void testLocationTypes() {
		String[] types = new String[] { "Airport", "Church", "City", "Country",
				"CrimeScene", "Harbor", "Home", "Location", "Office", "Prison",
				"Region", "Shop", "TrainStation" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties("maltego."
					+ typeStr);

			assertEquals(9, props.size());

			assertEquals(true, props.get("Name").isLabelProperty());
			assertEquals("Name", props.get("Name").getDisplayName());
			assertEquals("string", props.get("Name").getType());

			assertEquals(false, props.get("Street Address").isLabelProperty());
			assertEquals("Street Address", props.get("Street Address")
					.getDisplayName());
			assertEquals("string", props.get("Street Address").getType());

			assertEquals(false, props.get("Country Code").isLabelProperty());
			assertEquals("Country Code", props.get("Country Code")
					.getDisplayName());
			assertEquals("string", props.get("Country Code").getType());

			assertEquals(false, props.get("Area").isLabelProperty());
			assertEquals("Area", props.get("Area").getDisplayName());
			assertEquals("string", props.get("Area").getType());

			assertEquals(false, props.get("Area Code").isLabelProperty());
			assertEquals("Area Code", props.get("Area Code").getDisplayName());
			assertEquals("string", props.get("Area Code").getType());

			assertEquals(false, props.get("Longitude").isLabelProperty());
			assertEquals("Longitude", props.get("Longitude").getDisplayName());
			assertEquals("float", props.get("Longitude").getType());

			assertEquals(false, props.get("Latitude").isLabelProperty());
			assertEquals("Latitude", props.get("Latitude").getDisplayName());
			assertEquals("float", props.get("Latitude").getType());

			assertEquals(false, props.get("City").isLabelProperty());
			assertEquals("City", props.get("City").getDisplayName());
			assertEquals("string", props.get("City").getType());

			assertEquals(false, props.get("Country").isLabelProperty());
			assertEquals("Country", props.get("Country").getDisplayName());
			assertEquals("string", props.get("Country").getType());
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
			Map<String, PropertyModel> props = type.getProperties("maltego."
					+ typeStr);

			assertEquals(3, props.size());

			assertEquals(true, props.get("Full Name").isLabelProperty());
			assertEquals("Full Name", props.get("Full Name").getDisplayName());
			assertEquals("string", props.get("Full Name").getType());

			assertEquals(false, props.get("First Names").isLabelProperty());
			assertEquals("First Names", props.get("First Names")
					.getDisplayName());
			assertEquals("string", props.get("First Names").getType());

			assertEquals(false, props.get("Surname").isLabelProperty());
			assertEquals("Surname", props.get("Surname").getDisplayName());
			assertEquals("string", props.get("Surname").getType());
		}
	}

	@Test
	public void testTypeAlias() {
		Map<String, PropertyModel> props = type.getProperties("maltego.Alias");

		assertEquals(1, props.size());
		assertEquals(true, props.get("Alias").isLabelProperty());
		assertEquals("Alias", props.get("Alias").getDisplayName());
		assertEquals("string", props.get("Alias").getType());
	}

	@Test
	public void testTypeDocument() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.Document");

		assertEquals(3, props.size());
		assertEquals(true, props.get("Title").isLabelProperty());
		assertEquals("Title", props.get("Title").getDisplayName());
		assertEquals("string", props.get("Title").getType());

		assertEquals(false, props.get("Meta-Data").isLabelProperty());
		assertEquals("Meta-Data", props.get("Meta-Data").getDisplayName());
		assertEquals("string", props.get("Meta-Data").getType());

		assertEquals(false, props.get("URL").isLabelProperty());
		assertEquals("URL", props.get("URL").getDisplayName());
		assertEquals("url", props.get("URL").getType());
	}

	@Test
	public void testTypeEmailAddress() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.EmailAddress");

		assertEquals(1, props.size());
		assertEquals(true, props.get("Email Address").isLabelProperty());
		assertEquals("Email Address", props.get("Email Address")
				.getDisplayName());
		assertEquals("string", props.get("Email Address").getType());
	}

	@Test
	public void testTypeImage() {
		Map<String, PropertyModel> props = type.getProperties("maltego.Image");

		assertEquals(2, props.size());
		assertEquals(true, props.get("Description").isLabelProperty());
		assertEquals("Description", props.get("Description").getDisplayName());
		assertEquals("string", props.get("Description").getType());

		assertEquals(false, props.get("URL").isLabelProperty());
		assertEquals("URL", props.get("URL").getDisplayName());
		assertEquals("url", props.get("URL").getType());
	}

	@Test
	public void testTypePerson() {
		Map<String, PropertyModel> props = type.getProperties("maltego.Person");

		assertEquals(3, props.size());
		assertEquals(true, props.get("Full Name").isLabelProperty());
		assertEquals("Full Name", props.get("Full Name").getDisplayName());
		assertEquals("string", props.get("Full Name").getType());

		assertFalse(props.get("First Names").isLabelProperty());
		assertEquals("First Names", props.get("First Names").getDisplayName());
		assertEquals("string", props.get("First Names").getType());

		assertFalse(props.get("Surname").isLabelProperty());
		assertEquals("Surname", props.get("Surname").getDisplayName());
		assertEquals("string", props.get("Surname").getType());
	}

	@Test
	public void testPhoneNumberTypes() {
		String[] types = new String[] { "PhoneNumber", "PhoneNumberMobile",
				"PhoneNumberOffice", "PhoneNumberResidential" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties("maltego."
					+ typeStr);

			assertEquals(5, props.size());
			assertEquals(true, props.get("Phone Number").isLabelProperty());
			assertEquals("Phone Number", props.get("Phone Number")
					.getDisplayName());
			assertEquals("string", props.get("Phone Number").getType());

			assertEquals(false, props.get("City Code").isLabelProperty());
			assertEquals("City Code", props.get("City Code").getDisplayName());
			assertEquals("string", props.get("City Code").getType());

			assertEquals(false, props.get("Country Code").isLabelProperty());
			assertEquals("Country Code", props.get("Country Code")
					.getDisplayName());
			assertEquals("string", props.get("Country Code").getType());

			assertEquals(false, props.get("Area Code").isLabelProperty());
			assertEquals("Area Code", props.get("Area Code").getDisplayName());
			assertEquals("string", props.get("Area Code").getType());

			assertEquals(false, props.get("Last Digits").isLabelProperty());
			assertEquals("Last Digits", props.get("Last Digits")
					.getDisplayName());
			assertEquals("string", props.get("Last Digits").getType());
		}
	}

	@Test
	public void testTypePhrase() {
		Map<String, PropertyModel> props = type.getProperties("maltego.Phrase");

		assertEquals(1, props.size());
		assertEquals(true, props.get("Text").isLabelProperty());
		assertEquals("Text", props.get("Text").getDisplayName());
		assertEquals("string", props.get("Text").getType());
	}

	@Test
	public void testTypeAffiliationFacebook() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.affiliation.Facebook");

		assertEquals(4, props.size());
		assertEquals(true, props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());

		assertEquals(false, props.get("Profile URL")
				.isLabelProperty());
		assertEquals("Profile URL", props.get("Profile URL")
				.getDisplayName());
		assertEquals("string", props.get("Profile URL").getType());

		assertEquals(false, props.get("Network").isLabelProperty());
		assertEquals("Network", props.get("Network")
				.getDisplayName());
		assertEquals("string", props.get("Network").getType());

		assertEquals(false, props.get("UID").isLabelProperty());
		assertEquals("UID", props.get("UID").getDisplayName());
		assertEquals("string", props.get("UID").getType());
	}

	@Test
	public void testTypeAffiliationLinkedIn() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.affiliation.LinkedIn");

		assertEquals(4, props.size());
		assertEquals(true, props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());

		assertEquals(false, props.get("Profile URL")
				.isLabelProperty());
		assertEquals("Profile URL", props.get("Profile URL")
				.getDisplayName());
		assertEquals("string", props.get("Profile URL").getType());

		assertEquals(false, props.get("Network").isLabelProperty());
		assertEquals("Network", props.get("Network")
				.getDisplayName());
		assertEquals("string", props.get("Network").getType());

		assertEquals(false, props.get("UID").isLabelProperty());
		assertEquals("UID", props.get("UID").getDisplayName());
		assertEquals("string", props.get("UID").getType());
	}

	@Test
	public void testTypeAffiliationTwitter() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.affiliation.Twitter");

		assertEquals(8, props.size());
		assertEquals(true, props.get("Name").isLabelProperty());
		assertEquals("Name", props.get("Name").getDisplayName());
		assertEquals("string", props.get("Name").getType());

		assertEquals(false, props.get("Real Name").isLabelProperty());
		assertEquals("Real Name", props.get("Real Name").getDisplayName());
		assertEquals("string", props.get("Real Name").getType());

		assertEquals(false, props.get("Twitter Number").isLabelProperty());
		assertEquals("Twitter Number", props.get("Twitter Number")
				.getDisplayName());
		assertEquals("int", props.get("Twitter Number").getType());

		assertEquals(false, props.get("Profile URL")
				.isLabelProperty());
		assertEquals("Profile URL", props.get("Profile URL")
				.getDisplayName());
		assertEquals("string", props.get("Profile URL").getType());

		assertEquals(false, props.get("Screen Name").isLabelProperty());
		assertEquals("Screen Name", props.get("Screen Name")
				.getDisplayName());
		assertEquals("string", props.get("Screen Name").getType());

		assertEquals(false, props.get("Friend Count").isLabelProperty());
		assertEquals("Friend Count", props.get("Friend Count")
				.getDisplayName());
		assertEquals("int", props.get("Friend Count").getType());

		assertEquals(false, props.get("Network").isLabelProperty());
		assertEquals("Network", props.get("Network")
				.getDisplayName());
		assertEquals("string", props.get("Network").getType());

		assertEquals(false, props.get("UID").isLabelProperty());
		assertEquals("UID", props.get("UID").getDisplayName());
		assertEquals("string", props.get("UID").getType());
	}

	@Test
	public void testTypeBankAccount() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.BankAccount");

		assertEquals(3, props.size());
		assertEquals(true, props.get("Account Number").isLabelProperty());
		assertEquals("Account Number", props.get("Account Number")
				.getDisplayName());
		assertEquals("string", props.get("Account Number").getType());

		assertEquals(false, props.get("Branch Code").isLabelProperty());
		assertEquals("Branch Code", props.get("Branch Code").getDisplayName());
		assertEquals("string", props.get("Branch Code").getType());

		assertEquals(false, props.get("Bank").isLabelProperty());
		assertEquals("Bank", props.get("Bank").getDisplayName());
		assertEquals("string", props.get("Bank").getType());
	}

	@Test
	public void testTypeFlightNumber() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.FlightNumber");

		assertEquals(4, props.size());
		assertEquals(true, props.get("Flight ID").isLabelProperty());
		assertEquals("Flight ID", props.get("Flight ID").getDisplayName());
		assertEquals("string", props.get("Flight ID").getType());

		assertEquals(false, props.get("Airline").isLabelProperty());
		assertEquals("Airline", props.get("Airline").getDisplayName());
		assertEquals("string", props.get("Airline").getType());

		assertEquals(false, props.get("Date").isLabelProperty());
		assertEquals("Date", props.get("Date").getDisplayName());
		assertEquals("date", props.get("Date").getType());

		assertEquals(false, props.get("Flight Number").isLabelProperty());
		assertEquals("Flight Number", props.get("Flight Number")
				.getDisplayName());
		assertEquals("string", props.get("Flight Number").getType());
	}

	@Test
	public void testTypeIdentificationNumber() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.IdentificationNumber");

		assertEquals(1, props.size());
		assertEquals(true, props.get("Number").isLabelProperty());
		assertEquals("Number", props.get("Number")
				.getDisplayName());
		assertEquals("string", props.get("Number").getType());
	}

	@Test
	public void testTypeMacAddress() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.MacAddress");

		assertEquals(1, props.size());
		assertEquals(true, props.get("MAC Address").isLabelProperty());
		assertEquals("MAC Address", props.get("MAC Address").getDisplayName());
		assertEquals("string", props.get("MAC Address").getType());
	}

	@Test
	public void testTypePassportNumber() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.PassportNumber");

		assertEquals(1, props.size());
		assertEquals(true, props.get("Number").isLabelProperty());
		assertEquals("Number", props.get("Number")
				.getDisplayName());
		assertEquals("string", props.get("Number").getType());
	}

	@Test
	public void testTypeVehicleRegistration() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.VehicleRegistration");

		assertEquals(1, props.size());
		assertEquals(true, props.get("Registration Number").isLabelProperty());
		assertEquals("Registration Number", props.get("Registration Number")
				.getDisplayName());
		assertEquals("string", props.get("Registration Number").getType());
	}

	@Test
	public void testTypeVinNumber() {
		Map<String, PropertyModel> props = type
				.getProperties("maltego.VinNumber");

		assertEquals(1, props.size());
		assertEquals(true, props.get("VIN Number").isLabelProperty());
		assertEquals("VIN Number", props.get("VIN Number").getDisplayName());
		assertEquals("string", props.get("VIN Number").getType());
	}

	@Test
	public void testTransportationTypes() {
		String[] types = new String[] { "Bike", "Boat", "Bus", "Car", "Plane",
				"Train" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties("maltego." + typeStr);

			assertEquals(3, props.size());
			assertEquals(true, props.get("Name").isLabelProperty());
			assertEquals("Name", props.get("Name").getDisplayName());
			assertEquals("string", props.get("Name").getType());

			assertEquals(false, props.get("Make").isLabelProperty());
			assertEquals("Make", props.get("Make").getDisplayName());
			assertEquals("string", props.get("Make").getType());

			assertEquals(false, props.get("Model").isLabelProperty());
			assertEquals("Model", props.get("Model").getDisplayName());
			assertEquals("string", props.get("Model").getType());
		}
	}

	@Test
	public void testWeaponTypes() {
		String[] types = new String[] { "Ammunition", "BioWeapon", "Blade",
				"ChemicalWeapon", "Explosive", "Gun", "IED", "Missile",
				"NuclearWeapon" };

		for (String typeStr : types) {
			Map<String, PropertyModel> props = type.getProperties("maltego." + typeStr);

			assertEquals(1, props.size());
			assertEquals(true, props.get("Type").isLabelProperty());
			assertEquals("Type", props.get("Type").getDisplayName());
			assertEquals("string", props.get("Type").getType());
		}
	}
}
