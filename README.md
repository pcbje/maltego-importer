Maltego and Casefile supports copying and pasting of GraphML. The aim of this project to ease the task
of generating valid GraphML with Maltego's special needs from various dataformats.

#### Input format: CSV

<code>NodeTypeA,NodeLabelA,NodeTypeB,NodeLabelB,EdgeLabel</code>

Supported entity types are listed in the enum [MaltegoEntity](https://github.com/pcbje/maltego-importer/blob/master/src/main/java/com/pcbje/maltegoimporter/model/impl/MaltegoEntity.java).