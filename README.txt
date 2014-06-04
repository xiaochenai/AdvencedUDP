Run SenderV7.jar in All Senders

Run ReceiverV6.jar in All receivers

when receiver is running, run RunSenderStart.bat

how to run SenderV7.jar:
java -jar SenderV7.jar IP1 filename1 IP2 FileName2 ......

how to run ReceiverV6.jar
java -jar ReceiverV6.jar


or use windows batch file to run the source code:

run RunExcutorService.bat (this is the receiver)

run Runsender.bat (this is the sender, receiver's IP and the files to be sent can be changed here)

after all files are compiled and running

run RunSenderStart.bat