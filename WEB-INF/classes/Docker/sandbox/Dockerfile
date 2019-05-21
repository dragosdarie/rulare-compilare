FROM gcc:4.9
RUN mkdir sandbox
COPY . /sandbox
WORKDIR /sandbox
RUN gcc main.c
RUN ./a.out > output.txt

