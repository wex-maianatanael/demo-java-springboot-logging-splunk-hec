# demo-logging-splunk-hec
How to use Splunk HECs to ingest structured logs.

## Running the app locally

### Docker container
Run the following command in order to set up the splunk container.

```shell
docker compose up --build -d
```

### Splunk
You'll need to set up the splunk hec index, just like this:

- Disable SSL
- Attach index to the hec (there is an existing token we create at runtime)

### Java app
In order to run the java api locall, firstly you'll need to restore all the dependencies (maven/pom.xml), then build and run the app.
