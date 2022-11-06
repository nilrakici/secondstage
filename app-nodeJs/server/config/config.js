import { Joi } from 'express-validation';

require('dotenv').config();

const envVarsSchema = Joi.object({
  NODE_ENV: Joi.string()
    .valid('development', 'production', 'test', 'provision')
    .default('development'),
  PORT: Joi.number()
    .default(4000),
  API_VERSION: Joi.string()
    .default('1.0')
    .description('API Version'),
  JWT_SECRET: Joi.string().required()
    .description('JWT Secret required to sign'),
  DB_PG_DB: Joi.string()
    .default('api')
    .description('Postgres database name'),
  DB_PG_PORT: Joi.number()
    .default(5432),
  DB_PG_HOST: Joi.string()
    .default('localhost'),
  DB_PG_USER: Joi.string().required()
    .default('postgres')
    .description('Postgres username'),
  DB_PG_PASSWD: Joi.string().required('')
    .default('password')
    .description('Postgres password'),
  DB_PG_SSL: Joi.bool()
    .default(false)
    .description('Enable SSL connection to PostgreSQL'),
}).unknown().required();

const { error, value: envVars } = envVarsSchema.validate(process.env);
if (error) {
  throw new Error(`Config validation error: ${error.message}`);
}

const config = {
  env: envVars.NODE_ENV,
  port: envVars.PORT,
  apiVersion: envVars.API_VERSION,
  jwtSecret: envVars.JWT_SECRET,
  postgres: {
    db: envVars.DB_PG_DB,
    port: envVars.DB_PG_PORT,
    host: envVars.DB_PG_HOST,
    user: envVars.DB_PG_USER,
    passwd: envVars.DB_PG_PASSWD,
    ssl: envVars.DB_PG_SSL,
  },
};

export default config;
