rm -r Docker/sandbox > /dev/null
docker build -t compile-run ./Docker > /dev/null
docker rm ip-container
docker run --name=ip-container compile-run > /dev/null
docker cp ip-container:/sandbox ./Docker > /dev/null
