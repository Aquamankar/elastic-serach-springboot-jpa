# 🧠 Elasticsearch with Spring Boot and JPA

This project demonstrates how to combine **Elasticsearch** with **Spring Boot + JPA** to get the best of both worlds: relational data storage and powerful full-text search.

---

## 🔄 Use Case Comparison: JPA vs Elasticsearch

| Use Case                          | JPA                             | Elasticsearch                  |
|----------------------------------|----------------------------------|--------------------------------|
| Store structured data (relations)| ✅ Yes                          | ❌ No                           |
| Full-text search                 | ❌ Poor performance             | ✅ Yes                          |
| Filtering and joins              | ✅ Efficient with relations     | ❌ Not suitable                 |
| Autocomplete, fuzzy search       | ❌ No                           | ✅ Yes                          |
| Analytics and aggregation        | ❌ Complex                      | ✅ Fast                         |

---

## 🔍 Best Practice:

Use **JPA** for:
- Structured data
- Relationships
- Transactions

Use **Elasticsearch** for:
- Full-text search
- Autocomplete
- Filtering and scoring
- Analytics

---

## 🐳 Run Elasticsearch with Docker (No Docker Compose)

```bash
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "xpack.security.enabled=false" docker.elastic.co/elasticsearch/elasticsearch:8.12.2
