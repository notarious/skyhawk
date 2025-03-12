### Thought Process, Challenges, and Trade-offs

I focused on simplicity and scalability. The main goal was to make data available immediately after writing. To do this, I used a stateless REST API with an in-memory repository for the demo. The challenge was to balance high performance with future scalability. To keep overhead low and maintain control over database interactions, I avoided using an ORM. In production, migrating to a distributed database could further enhance fault tolerance and scalability.

### Architecture, Database Choices, Scalability, and Maintainability

I used a layered design (controller → service → repository) to separate concerns, making maintenance and testing easier. For the demo, an in-memory repository was chosen for its simplicity and immediate data access. In production, this would be replaced with a fault-tolerant DBMS (like PostgreSQL or a NoSQL database). This design supports scalability with stateless services for horizontal scaling and improves maintainability by isolating application layers.

### Design and Implementation Considerations

**Avoiding ORM:**
- Decided against ORM (e.g., Hibernate) due to potential overhead and performance degradation with large datasets.
- Manual SQL query management allows optimization and better system performance.

**In-memory repository vs. persistent storage:**
- Chose an in-memory repository for immediate data aggregation and availability during demonstrations.
- For production, a robust, fault-tolerant database (e.g., Amazon RDS) would be preferable.

**Docker usage:**
- Utilized Docker for containerization, enabling rapid deployment and scalability.
- This facilitates streamlined CI/CD processes and supports high availability.

### Running the Project

1. **Build the project:**
   ```shell
   mvn clean package
   ```

2. **Run with Docker:**
   ```shell
   docker-compose up --build
   ```
   *(Ensure a valid `docker-compose.yml` is provided.)*

3. **Test the API:**
  - **POST** `/api/log` with a JSON payload containing player statistics.
  - **GET** aggregated data from:
    - `/api/aggregate/player/{playerId}`
    - `/api/aggregate/team/{teamId}`

4. **Monitoring:**
  - Integrate Spring Actuator to monitor application health.

### Deployment on AWS

**Container orchestration:**
- AWS EKS to manage containers, ensuring auto-scaling and high availability.

- **Database:**  
  Use **Amazon RDS** for moderate load and complex SQL queries. If the load is very high and scalability is paramount, opt for **DynamoDB**. The choice depends on the expected data volume and query complexity.


**Load balancing:**
- AWS Elastic Load Balancer (ELB) to distribute traffic evenly across instances.

**Monitoring and logging:**
- AWS CloudWatch for monitoring, logging, and setting alerts to quickly identify and resolve issues.

**CI/CD:**
- AWS CodePipeline and AWS CodeDeploy to automate build, deployment, and maintain stable releases.
