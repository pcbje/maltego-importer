Maltego and Casefile supports copying and pasting of GraphML. The aim of this project to ease the task
of generating valid GraphML with Maltego's special needs from various dataformats.

#### Input format: CSV

<pre>
GangMember, Jon Doe,   Male,       Some random guy, Shoots
Female,     Some lady, Male,       Some random guy, Sees
Female,     Some lady, LawOfficer, Policeman,       Calls
LawOfficer, Policeman, Male,       Some random guy, Helps
LawOfficer, Policeman, GangMember, Jon Doe,         Arrests
</pre>

Supported entity types are listed in [MaltegoEntity](https://github.com/pcbje/maltego-importer/blob/master/src/main/java/com/pcbje/maltegoimporter/model/impl/MaltegoEntity.java).