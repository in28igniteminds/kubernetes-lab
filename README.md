# Deploy Springboot Microservices To Kubernetes Cluster And Expose Them

## Lab Introduction

Create docker images for Springboot microservices and deploy them to Kubernetes cluster

## Course Overview
Explains in detail how to deploy spring boot microservices to workspace

## Requirements
- Install JDK
- Install Maven
- Install Docker
- Install Ingress controller

## Who is this course for
- You are a programmer wanting to explore DevOps with Docker, Kubernetes and Azure DevOps
- You want to automate deployment of your microservices to the cloud using DevOps with Docker, Kubernetes and Azure DevOps

## Step By Step Details - Prepare the Environment

### Install JDK
```aidl
sudo apt update
sudo apt install openjdk-17-jdk-headless
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
echo $JAVA_HOME
PATH="$JAVA_HOME/bin:$PATH"
export PATH
```
### Install Maven
```aidl
wget https://dlcdn.apache.org/maven/maven-3/3.9.0/binaries/apache-maven-3.9.0-bin.tar.gz -P /tmp
sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt
sudo ln -s /opt/apache-maven-3.9.0 /opt/maven
sudo nano /etc/profile.d/maven.sh

Add these values in the maven.sh file and save it and close the file

    export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
    export M2_HOME=/opt/maven
    export MAVEN_HOME=/opt/maven
    export PATH=${M2_HOME}/bin:${PATH}
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh

Check the maven version
mvn -version
```

### Install Docker
```aidl
sudo apt install docker.io
```

### Install Nginix Ingress Controller
```aidl
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.6.4/deploy/static/provider/cloud/deploy.yaml

wait for ingress setup. When this command is finished controller is setup

kubectl wait --namespace ingress-nginx \
  --for=condition=ready pod \
  --selector=app.kubernetes.io/component=controller \
  --timeout=120s
```

## Step By Step Details - Deploy the applications


### Appendix - Installing Visual Studio Code
- Step 01 - Installing VS Code
- Step 02 - Download and Setup Projects in Visual Studio Code

#### Required Tools


