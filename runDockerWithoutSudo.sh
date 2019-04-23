# Daca aveti XAMPP instalat pe Linux:

# Cum se instaleaza docker:
# sudo apt-get install docker
# sudo apt-get install docker.io


# Acest script trebuie rulat o singura data ca sa nu fie nevoie de sudo
# pentru comanda docker

# Trebuie sa editam si fisierul de configurare al serverului Apache
# /opt/lampp/etc/httpd.conf

# Liniile: 
# User daemon
# Group daemon

# Devin
# User <userul cu care sunteti logati>
# Group <userul cu care sunteti logati>



sudo groupadd docker 
sudo gpasswd -a $USER docker
newgrp docker
