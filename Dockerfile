FROM clojure:latest
WORKDIR /usr/local/src
COPY . .
RUN lein deps
CMD ["lein", "run"]
