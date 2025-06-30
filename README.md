 #📘 Elasticsearch with Spring Boot & JPA
This project demonstrates how to use Elasticsearch alongside Spring Boot + JPA for full-text search functionality while using MySQL (or any RDBMS) for primary data persistence.

## 🛠 Tech Stack
Spring Boot 3.x

Spring Data JPA (MySQL)

Spring Data Elasticsearch

Elasticsearch 8.x (via Docker)

Docker 

## 🚀 Use Cases of Elasticsearch with JPA


Use Case                           JPA                        	Elasticsearch
Store structured data (relations)  ✅ Yes                     	❌ No
Full-text search	                 ❌ Poor performance          ✅ Yes
Filtering and joins                ✅ Efficient with relations	❌ Not suitable
Autocomplete, fuzzy search	       ❌ No	                      ✅ Yes
Analytics and aggregation	         ❌ Complex                 	✅ Fast

🔍 Best Practice:


Use JPA (MySQL) for CRUD, joins, transactions
Use Elasticsearch for search, suggestions, and text queries

