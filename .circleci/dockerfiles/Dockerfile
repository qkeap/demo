FROM google/cloud-sdk

RUN apt-get update && apt-get install -y tar gzip unzip zip
RUN curl --silent --show-error --location --fail --retry 3 --output /tmp/gradle.zip     https://services.gradle.org/distributions/gradle-5.2.1-bin.zip   && unzip -d /opt /tmp/gradle.zip   && rm /tmp/gradle.zip   && ln -s /opt/gradle-* /opt/gradle   && /opt/gradle/bin/gradle -version
ENV PATH="/opt/gradle/bin:$PATH"
