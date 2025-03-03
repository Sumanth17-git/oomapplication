 How to Test the OOM Scenario
1️⃣ Run with 512MB Heap (Expect OOM)
```bash
java -Xmx512M -jar target/oomapplication-0.0.1-SNAPSHOT.jar
```
2️⃣ Run with 2GB Heap (No OOM)
```bash
java -Xmx2G -jar target/oomapplication-0.0.1-SNAPSHOT.jar
```
