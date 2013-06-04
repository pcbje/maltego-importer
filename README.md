Maltego and Casefile supports copying and pasting of GraphML. The aim of this project to ease the task
of generating valid GraphML with Maltego's special needs from various dataformats.

Download the file maltego-importer.jar if you don't want to build the source yourself. You'll need to have Java 6 or higher installed.

#### Input format: Header based CSV

<pre>
GangMember, Male, Female, LawOfficer, GangMember, Male, Female, LawOfficer
Jon Doe,Some random guy,,,,,,,
,,Some lady,,,Some random guy,,Policeman
,,,Policeman,Jon Doe,Some random guy,,
</pre>

#### Input format: Value based CSV

<pre>
GangMember, Jon Doe,   Male,       Some random guy, Shoots
Female,     Some lady, Male,       Some random guy, Sees
Female,     Some lady, LawOfficer, Policeman,       Calls
LawOfficer, Policeman, Male,       Some random guy, Helps
LawOfficer, Policeman, GangMember, Jon Doe,         Arrests
</pre>

Supported entity types are listed in [MaltegoEntity](https://github.com/pcbje/maltego-importer/blob/master/src/main/java/com/pcbje/maltegoimporter/model/impl/MaltegoEntity.java).
