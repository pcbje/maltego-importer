package com.pcbje.maltegoimporter.model.impl;

public enum MaltegoEntity {
	LINK_MANUAL("maltego.link.manual-link"), DESKTOP_COMPUTER(
			"maltego.DesktopComputer"), DEVICE("maltego.Device"), MOBILE_COMPUTER(
			"maltego.MobileComputer"), MOBILE_PHONE("maltego.MobilePhone"), SMART_PHONE(
			"maltego.Smartphone"),

	CONVERSATION_EMAIL("maltego.ConversationEmail"), CONVERSATION_PHONE(
			"maltego.ConversationPhone"), INCIDENT("maltego.Incident"),

	MEETING_BUSINESS("maltego.MeetingBusiness"), MEETING_SOCIAL(
			"maltego.MeetingSocial"),

	COMPANY("maltego.Company"), EDUCATION_INSTITUTION(
			"maltego.EducationInstitution"), GANG("maltego.Gang"),

	ONLINE_GROUP("maltego.OnlineGroup"), ORGANIZATION("maltego.Organization"),

	POLITICAL_MOVEMENT("maltego.PoliticalMovement"), RELIGIOUS_GROUP(
			"maltego.ReligiousGroup"),

	AS("maltego.AS"), DNS_NAME("maltego.DNSName"), DOMAIN("maltego.Domain"), IPv4_ADDRESS(
			"maltego.IPv4Address"), MX_RECORD("maltego.MXRecord"), NS_RECORD(
			"maltego.NSRecord"), NETBLOCK("maltego.Netblock"), URL(
			"maltego.URL"), WEBSITE("maltego.Website"),

	AIRPORT("maltego.Airport"), CHURCH("maltego.Church"), CITY("maltego.City"), COUNTRY(
			"maltego.Country"), CRIME_SCENE("maltego.CrimeScene"), HARBOR(
			"maltego.Harbor"), HOME("maltego.Home"), LOCATION(
			"maltego.Location"), OFFICE("maltego.Office"), PRISON(
			"maltego.Prison"), REGION("maltego.Region"), SHOP("maltego.Shop"), TRAIN_STATION(
			"maltego.TrainStation"),

	BUSINESS_LEADER("maltego.BusinessLeader"), BUSINESS_MAN(
			"maltego.Businessman"), CHILD("maltego.Child"), DRUG_DEALER(
			"maltego.DrugDealer"), FEMALE("maltego.Female"), GANG_LEADER(
			"maltego.GangLeader"), GANG_MEMBER("maltego.GangMember"), GOVERNMENT_OFFICIAL(
			"maltego.GovernmentOfficial"), JUDGE("maltego.Judge"), LAW_OFFICER(
			"maltego.LawOfficer"), LAWYER("maltego.Lawyer"), MALE(
			"maltego.Male"), MILITARY_OFFICER("maltego.MilitaryOfficer"), SEX_OFFENDER(
			"maltego.SexOffender"), TERRORIST("maltego.Terrorist"), TERRORIST_LEADER(
			"maltego.TerroristLeader"), UNSUB("maltego.Unsub"),

	ALIAS("maltego.Alias"), DOCUMENT("maltego.Document"), EMAIL_ADDRESS(
			"maltego.EmailAddress"), IMAGE("maltego.Image"), PERSON(
			"maltego.Person"), PHONE_NUMBER("maltego.PhoneNumber"), PHONE_NUMBER_MOBILE(
			"maltego.PhoneNumberMobile"), PHONE_NUMBER_OFFICE(
			"maltego.PhoneNumberOffice"), PHONE_NUMBER_RESIDENTIAL(
			"maltego.PhoneNumberResidential"), PHRASE("maltego.Phrase"),

	AFFILIATION_FACEBOOK("maltego.affiliation.Facebook"), AFFILIATION_LINKEDIN(
			"maltego.affiliation.LinkedIn"), AFFILIATION_TWITTER(
			"maltego.affiliation.Twitter"),

	BANK_ACCOUNT("maltego.BankAccount"), FLIGHT_NUMBER("maltego.FlightNumber"), IDENTIFICATION_NUMBER(
			"maltego.IdentificationNumber"), MAC_ADDRESS("maltego.MacAddress"), PASSPORT_NUMBER(
			"maltego.PassportNumber"), VEHICLE_REGISTRATION(
			"maltego.VehicleRegistration"), VIN_NUMBER("maltego.VinNumber"),

	BIKE("maltego.Bike"), BOAT("maltego.Boat"), BUS("maltego.Bus"), CAR(
			"maltego.Car"), PLANE("maltego.Plane"), TRAIN("maltego.Train"),

	AMMUNITION("maltego.Ammunition"), BIO_WEAPON("maltego.BioWeapon"), BLADE(
			"maltego.Blade"), CHEMICAL_WEAPON("maltego.ChemicalWeapon"), EXPLOSIVE(
			"maltego.Explosive"), GUN("maltego.Gun"), IED("maltego.IED"), MISSILE(
			"maltego.Missile"), NUCLEAR_WEAPON("maltego.NuclearWeapon");

	private String name;

	MaltegoEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
