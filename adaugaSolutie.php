<?php

$ram=32;
$cpu_cores_allowed=1;

$cod = $_POST['input_cod'];

echo $cod;
chdir('Docker');
$file='main.c';
file_put_contents($file, $cod); 
echo '<br>';

$docker_run_command=sprintf("docker run --memory=%dm --cpus=%d compile-run 2>&1", $ram, $cpu_cores_allowed);

echo $docker_run_command;

//echo shell_exec('./compile-run.sh 2>&1'); // 2>&1 : write stderr to stdout
shell_exec('docker build -t compile-run .');
echo '<br>';
//echo shell_exec('docker run compile-run 2>&1');

shell_exec('docker network connect no-internet compile-run 2>&1'); // restrict 
//network access

echo shell_exec($docker_run_command);


echo '<br>';


//echo $output;

?>



