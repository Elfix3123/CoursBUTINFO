FROM alpine

RUN apk update
RUN apk add php83 php83-openssl php83-phar php83-iconv 
RUN wget https://raw.githubusercontent.com/composer/getcomposer.org/f3108f64b4e1c1ce6eb462b159956461592b3e3e/web/installer -O - -q | php -- --quiet
RUN mv composer.phar /usr/local/bin/composer

