UTEID: lmh2742;krm965;

FIRSTNAME: Lauren; Kyle;

LASTNAME: Hunter; Martinez;

CSACCOUNT: hunter7;...;

EMAIL: hunter7@cs.utexas.edu;kylemartinez10@;


[Program 1]
[Description]
There are eight files: In Subject.java, we created the subject class which contains a subject name, security level and a read value, and a read value function which sets the subjects read value to the value given. In Object.java, we created the object class which contains an object name, security level and a write value, and a write value function which sets the objects value to the value given. In SecurityLevel.java, we defined high and low levels and created a dominates function that returns true if a security level dominates another and false otherwise. In InstructionType.java, we defined the three different instruction types, READ, WRITE and BAD. In InstructionObject.java, we created a class to handle an Instruction. An InstructionObject contains a subjectName, objectName, value for a write instruction, and an InstructionType. In ReferenceMonitor.java, we created an ObjectManager class which manages the set of objects. It also contains the class ReferenceMonitor which contains an ObjectMangaer and the set of subjects and handles all the logic behind the BLPs. ExecuteInstruction takes in an IntstuctionObject and it either executes the instruction or denys the action based on the BLP's policies. ReferenceMonitor also contains methods to print out the state of the subjects and objects. In BLPSystem.java, ...

To compile code: you must be in the company directory and javac *.java will do the trick. 
To execute code: you must be in the src directory (cd ../..) and the command is
java com.company.SecureSystem pwd/com/company/instructionListX.txt 
where pwd is the path from with in src

[Finish]
We finished all of the assignment except for the extra credit. 

[Test case]
[INPUT of test 1]
write Hal HObj 
read Hal 
write Lyle LObj 10
read Hal LObj 
write Lyle HObj 20
write Hal LObj 200
read Hal HObj
read Lyle LObj
read Lyle HObj
foo Lyle LObj
Hi Lyle,This is Hal
The missile launch code is 1234567

[OUTPUT of test 1]
Reading from file: instructionList1.txt
write Hal HObj
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

read Hal
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

write Lyle LObj 10
write Instruction
The current state is:
LObjhas value: 10
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

read Hal LObj
Read Instruction
The current state is:
LObjhas value: 10
HObjhas value: 0
Halhas recently read: 10
Lylehas recently read: 0

write Lyle HObj 20
write Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 10
Lylehas recently read: 0

write Hal LObj 200
write Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 10
Lylehas recently read: 0

read Hal HObj
Read Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 20
Lylehas recently read: 0

read Lyle LObj
Read Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 20
Lylehas recently read: 10

read Lyle HObj
Read Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 20
Lylehas recently read: 0

foo Lyle LObj
Bad Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 20
Lylehas recently read: 0

Hi Lyle,This is Hal
Bad Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 20
Lylehas recently read: 0

The missile launch code is 1234567
Bad Instruction
The current state is:
LObjhas value: 10
HObjhas value: 20
Halhas recently read: 20
Lylehas recently read: 0


[INPUT of test 2]
write Lyle HObj 15
read Lyle HObj
read Lyle LObj
write Lyle LObj 10
read Lyle LObj
cats Lyle HObj
write Hal LObj 12
read Hal LObj
write Hal HObj 200
read Lyle HObj
sneaky Lyle LObj 10

[OUTPUT of test 2]
Reading from file: instructionList2.txt
write Lyle HObj 15
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 15
Halhas recently read: 0
Lylehas recently read: 0

read Lyle HObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 15
Halhas recently read: 0
Lylehas recently read: 0

read Lyle LObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 15
Halhas recently read: 0
Lylehas recently read: 0

write Lyle LObj 10
write Instruction
The current state is:
LObjhas value: 10
HObjhas value: 15
Halhas recently read: 0
Lylehas recently read: 0

read Lyle LObj
Read Instruction
The current state is:
LObjhas value: 10
HObjhas value: 15
Halhas recently read: 0
Lylehas recently read: 10

cats Lyle HObj
Bad Instruction
The current state is:
LObjhas value: 10
HObjhas value: 15
Halhas recently read: 0
Lylehas recently read: 10

write Hal LObj 12
write Instruction
The current state is:
LObjhas value: 10
HObjhas value: 15
Halhas recently read: 0
Lylehas recently read: 10

read Hal LObj
Read Instruction
The current state is:
LObjhas value: 10
HObjhas value: 15
Halhas recently read: 10
Lylehas recently read: 10

write Hal HObj 200
write Instruction
The current state is:
LObjhas value: 10
HObjhas value: 200
Halhas recently read: 10
Lylehas recently read: 10

read Lyle HObj
Read Instruction
The current state is:
LObjhas value: 10
HObjhas value: 200
Halhas recently read: 10
Lylehas recently read: 0

sneaky Lyle LObj 10
Bad Instruction
The current state is:
LObjhas value: 10
HObjhas value: 200
Halhas recently read: 10
Lylehas recently read: 0


[Input of test 3]
read Lyle LObj
write Lyle HObj 78
read Lyle HObj
write Hal LObj 10
read Hal LObj
read Hal HObj
write Hal HObj 25
kyle lauren security 10
cats and dogs
read Hal HObj 
write Lyle HObj 1
read Hal HObj

[output of test 3]
Reading from file: instructionList3.txt
read Lyle LObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

write Lyle HObj 78
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 78
Halhas recently read: 0
Lylehas recently read: 0

read Lyle HObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 78
Halhas recently read: 0
Lylehas recently read: 0

write Hal LObj 10
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 78
Halhas recently read: 0
Lylehas recently read: 0

read Hal LObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 78
Halhas recently read: 0
Lylehas recently read: 0

read Hal HObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 78
Halhas recently read: 78
Lylehas recently read: 0

write Hal HObj 25
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 25
Halhas recently read: 78
Lylehas recently read: 0

kyle lauren security 10
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 25
Halhas recently read: 78
Lylehas recently read: 0

cats and dogs
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 25
Halhas recently read: 78
Lylehas recently read: 0

read Hal HObj 
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 25
Halhas recently read: 78
Lylehas recently read: 0

write Lyle HObj 1
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 1
Halhas recently read: 78
Lylehas recently read: 0

read Hal HObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 1
Halhas recently read: 1
Lylehas recently read: 0

[Input of test 4]
WRITE HAL HOBJ 10
READ HAL
READ HAL HOBJ
WRITE LYLE LOBJ 23
ASJDLFASF ALSKJDFLASK AJSLDKFAJ
cATS AND dogs, and hampsters
or elephants
write Lyle HObj 12
read Hal HObj 
read Hal LObj        
write Hal LObj 52
read Lyle LObj

[output of test 4]
Reading from file: instructionList4.txt
WRITE HAL HOBJ 10
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

READ HAL
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

READ HAL HOBJ
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

WRITE LYLE LOBJ 23
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

ASJDLFASF ALSKJDFLASK AJSLDKFAJ
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

cATS AND dogs, and hampsters
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

or elephants
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 0
Halhas recently read: 0
Lylehas recently read: 0

write Lyle HObj 12
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 12
Halhas recently read: 0
Lylehas recently read: 0

read Hal HObj 
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 12
Halhas recently read: 0
Lylehas recently read: 0

read Hal LObj 
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 12
Halhas recently read: 0
Lylehas recently read: 0

write Lyle LObj 123        
Bad Instruction
The current state is:
LObjhas value: 0
HObjhas value: 12
Halhas recently read: 0
Lylehas recently read: 0

write Hal LObj 52
write Instruction
The current state is:
LObjhas value: 0
HObjhas value: 12
Halhas recently read: 0
Lylehas recently read: 0

read Lyle LObj
Read Instruction
The current state is:
LObjhas value: 0
HObjhas value: 12
Halhas recently read: 0
Lylehas recently read: 0