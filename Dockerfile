FROM openjdk:17.0.1-slim-bullseye

# Install Google Chrome
RUN apt update && \
    apt install -y curl unzip && \
    curl -L -o /tmp/google-chrome-stable_current_amd64.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    apt install -y --fix-broken /tmp/google-chrome-stable_current_amd64.deb && \
    rm /tmp/google-chrome-stable_current_amd64.deb

# Install Gradle
ENV GRADLE_VERSION=7.3.3
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
