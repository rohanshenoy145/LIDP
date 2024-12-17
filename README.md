# LIDP Software Engineer Challenge
![Static Badge](https://img.shields.io/badge/v2-test)

## Overview
The provided base application allows a user to view a list of customers through an HTTP interface. Utilizing Spring, a popular Java framework, the application hosts the services, and an embedded database.

Spring Boot is used for hosting all facets of the application.

An embedded in-memory H2 database stores the data used by the application. The default schema and some data is defaulted on application startup.

More details on the project, libraries, and additional resources can be found in the repository’s **HELP.md** file.

## Required
- [ ] Support a new database table, “address” that will store a customer’s addresses. Noting that a customer can have multiple addresses
- [ ] Create the appropriate relationship between a customer and address entity using JPA
- [ ] Expose CRUD operations on the customer that allows for maintenance of their addresses
- [ ] Ensure all data persists in the database, even after a restart
- [ ] Separate the persistence domain from the interface domain and implement the appropriate mappers
- [ ] Support 3 new endpoints that access data in the “sales” table that will do the following:
    - [ ] Return total sales amount for a given date range
    - [ ] Total sales amount for a given client
    - [ ] Return a subset of sales data that can be used to graph (x-axis time, y-axis sales) within a given date range

> [!NOTE]
> To ensure mathematical precision use Java’s BigDecimal library for all math-based calculations/operations.
   All web service endpoints should follow the REST standard

### Optional Challenge
- [ ] There is a major anti-pattern within the code base. Identify and resolve it.

## Questions?
LIDP encourages questions! If you need clarification on requirements or technical support, please send an email to [matthew.segreti@lidp.com](mailto:matthew.segreti@lidp.com).
