rm -r Docker/sandbox 
docker build -t compile-run ./Docker
docker rm ip-container
docker run --name=ip-container compile-run
docker cp ip-container:/sandbox ./Docker
