FROM openjdk:11

RUN mkdir /Project

COPY bin/ /Project

CMD java com.cisco.clinic.PhaseEndProjectApplication
