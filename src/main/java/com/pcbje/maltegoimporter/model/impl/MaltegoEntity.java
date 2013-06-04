package com.pcbje.maltegoimporter.model.impl;

/**
 * Enums representing the supported Maltego entity types for this parser.
 * 
 * @author pcbje
 */
public enum MaltegoEntity {
	LINK_MANUAL("link.manual-link"), DESKTOP_COMPUTER("DesktopComputer"), DEVICE(
			"Device"), MOBILE_COMPUTER("MobileComputer"), MOBILE_PHONE(
			"MobilePhone"), SMART_PHONE("Smartphone"),

	CONVERSATION_EMAIL("ConversationEmail"), CONVERSATION_PHONE(
			"ConversationPhone"), INCIDENT("Incident"),

	MEETING_BUSINESS("MeetingBusiness"), MEETING_SOCIAL("MeetingSocial"),

	COMPANY("Company"), EDUCATION_INSTITUTION("EducationInstitution"), GANG(
			"Gang"),

	ONLINE_GROUP("OnlineGroup"), ORGANIZATION("Organization"),

	POLITICAL_MOVEMENT("PoliticalMovement"), RELIGIOUS_GROUP("ReligiousGroup"),

	AS("AS"), DNS_NAME("DNSName"), DOMAIN("Domain"), IPv4_ADDRESS("IPv4Address"), MX_RECORD(
			"MXRecord"), NS_RECORD("NSRecord"), NETBLOCK("Netblock"), URL("URL"), WEBSITE(
			"Website"),

	AIRPORT("Airport"), CHURCH("Church"), CITY("City"), COUNTRY("Country"), CRIME_SCENE(
			"CrimeScene"), HARBOR("Harbor"), HOME("Home"), LOCATION("Location"), OFFICE(
			"Office"), PRISON("Prison"), REGION("Region"), SHOP("Shop"), TRAIN_STATION(
			"TrainStation"),

	BUSINESS_LEADER("BusinessLeader"), BUSINESS_MAN("Businessman"), CHILD(
			"Child"), DRUG_DEALER("DrugDealer"), FEMALE("Female"), GANG_LEADER(
			"GangLeader"), GANG_MEMBER("GangMember"), GOVERNMENT_OFFICIAL(
			"GovernmentOfficial"), JUDGE("Judge"), LAW_OFFICER("LawOfficer"), LAWYER(
			"Lawyer"), MALE("Male"), MILITARY_OFFICER("MilitaryOfficer"), SEX_OFFENDER(
			"SexOffender"), TERRORIST("Terrorist"), TERRORIST_LEADER(
			"TerroristLeader"), UNSUB("Unsub"),

	ALIAS("Alias"), DOCUMENT("Document"), EMAIL_ADDRESS("EmailAddress"), IMAGE(
			"Image"), PERSON("Person"), PHONE_NUMBER("PhoneNumber"), PHONE_NUMBER_MOBILE(
			"PhoneNumberMobile"), PHONE_NUMBER_OFFICE("PhoneNumberOffice"), PHONE_NUMBER_RESIDENTIAL(
			"PhoneNumberResidential"), PHRASE("Phrase"),

	AFFILIATION_FACEBOOK("affiliation.Facebook"), AFFILIATION_LINKEDIN(
			"affiliation.LinkedIn"), AFFILIATION_TWITTER("affiliation.Twitter"),

	BANK_ACCOUNT("BankAccount"), FLIGHT_NUMBER("FlightNumber"), IDENTIFICATION_NUMBER(
			"IdentificationNumber"), MAC_ADDRESS("MacAddress"), PASSPORT_NUMBER(
			"PassportNumber"), VEHICLE_REGISTRATION("VehicleRegistration"), VIN_NUMBER(
			"VinNumber"),

	BIKE("Bike"), BOAT("Boat"), BUS("Bus"), CAR("Car"), PLANE("Plane"), TRAIN(
			"Train"),

	AMMUNITION("Ammunition"), BIO_WEAPON("BioWeapon"), BLADE("Blade"), CHEMICAL_WEAPON(
			"ChemicalWeapon"), EXPLOSIVE("Explosive"), GUN("Gun"), IED("IED"), MISSILE(
			"Missile"), NUCLEAR_WEAPON("NuclearWeapon"),
                        
        UNKNOWN("Unknown");

	private String name;

	MaltegoEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
        
        @Override
        public String toString() {
            return name;
        }
}
