max_swap=64m
ram=32m
cpu_cores_allowed=1
#docker run --name=ip-container --memory=$ram --cpus=$cpu_cores_allowed --memory-swap=$max_swap --network none compile-run




rm -r Docker/sandbox 


output="$(docker images -a | grep compile-run | wc -l)"

#if [ $output -eq 0 ]
#then
    
#fi
docker build -t compile-run ./Docker
docker rm ip-container
docker run --name=ip-container --memory=$ram --cpus=$cpu_cores_allowed --memory-swap=$max_swap --network none  compile-run
docker cp ip-container:/sandbox ./Docker
