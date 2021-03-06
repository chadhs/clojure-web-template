# {{name}}

  FIXME


## Prerequisites

You will need [Leiningen](https://github.com/technomancy/leiningen) 2.0.0 or above installed.


## Development Mode

### Set Environment Variables & Secrets

Copy the example file, and update the values.

```sh
cp profiles_example.clj profiles.clj
```

### Setup Local Development Database

{{name}} uses postgresql; you'll need this availalbe for local dev.  to create a local dev database run the following commands.

```sh
createdb {{name}}-dev
lein migratus migrate
```

### One alias to rule them all

This alias should do all that is necessary in one step for local development.

```sh
lein dev
```

### Running the local development web server

To start a web server for local live development of the application, run:

```sh
lein ring server
```

### Automatically Recompile CSS File on Changes

```sh
lein garden auto
```


## Database Migrations

- the clojure migratus library is used to handle db schema changes.
- migrations are located in the `resources/migrations` folder.
- to create a new migration `lein migratus create <descriptive-name>` and then edit the `up` and `down` files created.
- migrations are applied automatically see config.clj and core.clj
- to manually apply migrations to your local dev instance `lein migratus migrate`


## Production Setup

you'll need to load the following environment variables in your production environment:

- `DATABASE_URL`
- `PORT`
- `SESSION_COOKIE_KEY`

optionally you can customize the following variables in your production environment:

- `REPORTED_LOG_LEVEL` (defaults to "warn"; set's min level to write to production log)
- `LOG_APPENDER` (options "println" "sentry")
- `SENTRY_DSN` (required only if you've set log-appender to "sentry")


## License

Copyright © Chad Stovern All rights reserved.
