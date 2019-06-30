# C02_BPJ2 Backend


## Current Build Status
[![Build Status](https://travis-ci.com/cwerner1/C02_BPJ2_Backend.svg?token=hXztLjB3o9gWgo5eS6xV&branch=master)](https://travis-ci.com/cwerner1/C02_BPJ2_Backend)
[![Coverage Status](https://coveralls.io/repos/github/cwerner1/C02_BPJ2_Backend/badge.svg)](https://coveralls.io/github/cwerner1/C02_BPJ2_Backend)

## Mysql

###  MYSQL connector tutorial
https://spring.io/guides/gs/accessing-data-mysql/


#### Mysql On MacOX start:
```
cd /usr/local/mysql/support-files
sudo ./mysql.server start
```


### Database Settings

src/main/resources/application.properties
DatabaseConnection String 

#### Mysql Setup for DAtabse
```
use sys;
CREATE DATABASE flattery;
CREATE USER 'flattery'@'%' identified by 'Flattery1!';
use flattery;
GRANT ALL privileges on flattery.* TO 'flattery'@'%' with grant option ; 
FLUSH privileges;


```

### Demo - adding and recieving Data
```com.flattery.WohnungController ```

#### add Entry
```/demo/add?email=email&email=email```

#### Show all entrys 
```/demo/all```