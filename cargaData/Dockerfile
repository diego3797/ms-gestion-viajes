FROM mongo:latest
# Will be set through Environment Files
ARG DATABASE_URI
ARG USERNAME
ARG PASSWORD

ENV DATABASE_URI ${DATABASE_URI}
ENV USERNAME ${USERNAME}
ENV PASSWORD ${PASSWORD}

COPY Trips.json /Trips.json

CMD mongoimport --username ${USERNAME} --password ${PASSWORD} --uri ${DATABASE_URI} --collection Viajes --drop --file /Trips.json --jsonArray