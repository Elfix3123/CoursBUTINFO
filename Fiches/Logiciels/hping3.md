# hping3
  
- `hping3` : opens interactive client  
- `hping3 [HOST]` : sends TCP packets to HOST 
	- `-p PORT` : sets TCP destination port
	- `-S` : sets SYN TCP flag
	- `-d SIZE` : sets packet body size
	- `-w SIZE` : sets TCP window size
	- `--flood` : sends packets as fast as possible
	- `--rand-source` : sends packets with random source address