FROM openjdk:17.0.1-slim-bullseye

# Install required packages
RUN apt update && apt install -y \
    # For downloading files
    curl unzip \
    && apt clean \
    && rm -rf /var/lib/apt/lists/*

# Install Gradle
ENV GRADLE_VERSION=7.3.3
ENV GRADLE_HOME=/usr/local/gradle-${GRADLE_VERSION}
ENV PATH="$PATH:$GRADLE_HOME/bin"
WORKDIR /usr/local
RUN curl -L https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle-${GRADLE_VERSION}-bin.zip && \
    unzip gradle-${GRADLE_VERSION}-bin.zip && \
    rm gradle-${GRADLE_VERSION}-bin.zip
