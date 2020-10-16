FROM openjdk:8

# Install Google Chrome
RUN apt-get update && \
    apt-get install -y curl unzip xvfb libxi6 libgconf-2-4 && \
    curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64]  http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list && \
    apt-get -y update && \
    apt-get -y install google-chrome-stable

# Install Gradle
ENV GRADLE_VERSION=6.6.1
ENV GRADLE_HOME=/usr/local/gradle-${GRADLE_VERSION}
ENV PATH="$PATH:$GRADLE_HOME/bin"
WORKDIR /usr/local
RUN curl -L https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-all.zip -o gradle-${GRADLE_VERSION}-all.zip && \
    unzip gradle-${GRADLE_VERSION}-all.zip && \
    rm gradle-${GRADLE_VERSION}-all.zip

# Create a user and use it because the ChromeHeadless does not support running as root without --no-sandbox.
ENV USER_NAME="ci"
RUN useradd -ms /bin/bash ${USER_NAME} && \
    chown -R ${USER_NAME}: /usr && \
    chmod -R 777 /usr
USER ${USER_NAME}

# Create a directory for the source code.
WORKDIR /usr/src/myapp
