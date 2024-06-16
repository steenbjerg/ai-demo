# ai-demo

This project plays with accessing openai from a quarkus application. The first experiment is making a chat implementation by using the completions api from openai.

## Quarkus dev

You need to setup your apikey towards openai before running quarkus dev. The reason is to avoid committing the api key.

´´´{script}
export OPENAI_KEY=<your key>
´´´