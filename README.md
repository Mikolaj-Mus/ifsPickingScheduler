The project's task is to assign orders in the most favorable way possible to employees. If a particular employee cannot take on a specific task, the next one is considered, and if no one can take on the order, it is rejected.

The program includes an algorithm that sorts orders based on their priority, which is determined by subtracting the execution time of the order from the time it needs to be placed. Then, such orders are assigned to a picker who has more remaining work time. The code includes several tests that check the correctness of the order in which the orders are placed.

The program uses libraries such as:
- google.code.gson
- Maven: io.rest-assured:rest-assured-common:5.3.0
- Maven: junit:junit:4.13.2
- Maven: org.apache.commons:commons-lang3:3.11
- Maven: org.apache.groovy:groovy:4.0.6
- Maven: org.hamcrest:hamcrest-core:1.3


The files contain a folder named "self-test-data", which contains JSON files with orders and employees. They are required as data for the program. In the test checks, you must provide your own absolute paths to the files containing the data.
