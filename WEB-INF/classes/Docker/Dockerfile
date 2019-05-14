FROM gcc:4.9
COPY . /temp
WORKDIR /temp
RUN gcc main.c
COPY /temp/a.out /usr/src/app/a.out
CMD ["/usr/src/app/a.out"]
