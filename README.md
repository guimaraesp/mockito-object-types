# Test object types ☺ #

The objective of this project is to clarify about the three types of testing objects using Mockito do see it.

* Mock: Simulated objects with specific behavioral expectations, when created they have all properties nullable or relative to it (like an integer as 0).<br>
* Stub: It is a mock with the addition of instructions on how to respond to certain attribute and method calls specifics to a limited test scenario <br>
* Spy: Real objects monitored during testing to verify their real behavior, generally a class instance with the ability to stub methods and submethods calls. <br>
<br>
You can find a test class to start at: `src/test/java/NewsletterSenderTest.java`