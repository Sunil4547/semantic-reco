Overview : 

This project implements a semantic recommendation system for an e-commerce fashion product line. Traditional keyword-based searches are replaced with human-like natural language queries (e.g., "I need an outfit for a summer beach party"). The system uses:

TextBuilder – converts products and queries into text for embeddings

Embeddings / Semantic Search – vectorizes queries and products for similarity search

Recommendation API – exposes an endpoint for querying recommended products

High-level flow:

User → Recommendation API → TextBuilder → Embedding Service → Search Service → Product Dataset → API Response

Components:

User – sends natural language query

API / Controller – receives queries and returns recommendations

TextBuilder – converts query and product fields into a single text string

Embedding Service – generates vector embeddings for semantic search

Search Service – computes similarity between query embedding and product embeddings

Product Dataset – JSON file containing product data, including fields like title, category, description, features, price, images, videos, and more

Response – list of recommended products returned to the user

Project Setup
Prerequisites

Java 17+

Maven 3+

Internet connection (for Maven dependency downloads)

Optional: Lombok plugin installed in IntelliJ