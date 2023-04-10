# build stage
FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
# CMD ["npm", "run", "serve"]

# production stage
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /app/dist /app/cart
RUN rm /etc/nginx/conf.d/default.conf
COPY ./nginx.conf /etc/nginx/conf.d
EXPOSE 2222
CMD ["nginx", "-g", "daemon off;"]
