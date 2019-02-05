

-- Table: silent.chat

-- DROP TABLE silent.chat;
CREATE SEQUENCE silent.chat_id_seq START 1 NO CYCLE;
CREATE TABLE silent.chat (
  id bigint NOT NULL DEFAULT nextval('silent.chat_id_seq'),
  name character varying(30) NOT NULL,
  CONSTRAINT chat_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE silent.chat
  OWNER TO silent;

  -- Table: silent."user"

  -- DROP TABLE silent."user";
  CREATE SEQUENCE silent.user_id_seq START 1 NO CYCLE;
  CREATE TABLE silent."user"
  (
    id bigint NOT NULL DEFAULT nextval('silent.user_id_seq'::regclass),
    name character varying(30) NOT NULL,
    login character varying(30) NOT NULL,
    salt character varying(30) NOT NULL,
    password character varying(60) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
  )
  WITH (
    OIDS=FALSE
  );
  ALTER TABLE silent."user"
    OWNER TO silent;

    -- Table: silent.message

    -- DROP TABLE silent.message;
    CREATE SEQUENCE silent.message_id_seq START 1 NO CYCLE;
    CREATE TABLE silent.message
    (
      id bigint NOT NULL DEFAULT nextval('silent.message_id_seq'::regclass),
      user_id bigint NOT NULL,
      chat_id bigint NOT NULL,
      text text NOT NULL,
      "time" time without time zone NOT NULL,
      CONSTRAINT message_pk PRIMARY KEY (id),
      CONSTRAINT chat_fk FOREIGN KEY (chat_id)
          REFERENCES silent.chat (id) MATCH SIMPLE
          ON UPDATE CASCADE ON DELETE NO ACTION,
      CONSTRAINT user_fk FOREIGN KEY (user_id)
          REFERENCES silent."user" (id) MATCH SIMPLE
          ON UPDATE CASCADE ON DELETE NO ACTION
    )
    WITH (
      OIDS=FALSE
    );
    ALTER TABLE silent.message
      OWNER TO silent;

    -- Index: silent.fki_chat

    -- DROP INDEX silent.fki_chat;

    CREATE INDEX fki_chat
      ON silent.message
      USING btree
      (chat_id);

    -- Index: silent.fki_user_fk

    -- DROP INDEX silent.fki_user_fk;

    CREATE INDEX fki_user_fk
      ON silent.message
      USING btree
      (user_id);

      -- Table: silent."right"

      -- DROP TABLE silent."right";
      CREATE SEQUENCE silent.right_id_seq START 1 NO CYCLE;
      CREATE TABLE silent."right"
      (
        id bigint NOT NULL DEFAULT nextval('silent.right_id_seq'::regclass),
        user_id bigint NOT NULL,
        chat_id bigint NOT NULL,
        write boolean NOT NULL DEFAULT false,
        invite boolean NOT NULL DEFAULT false,
        exclude boolean NOT NULL DEFAULT false,
        remove boolean NOT NULL DEFAULT false,
        rule boolean NOT NULL DEFAULT false,
        CONSTRAINT right_pk PRIMARY KEY (id),
        CONSTRAINT chat_fk FOREIGN KEY (chat_id)
            REFERENCES silent.chat (id) MATCH SIMPLE
            ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT user_fk FOREIGN KEY (user_id)
            REFERENCES silent."user" (id) MATCH SIMPLE
            ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT user_chat_unique UNIQUE (user_id, chat_id)
      )
      WITH (
        OIDS=FALSE
      );
      ALTER TABLE silent."right"
        OWNER TO silent;

      -- Index: silent.fki_chat_fk

      -- DROP INDEX silent.fki_chat_fk;

      CREATE INDEX fki_chat_fk
        ON silent."right"
        USING btree
        (chat_id);
      
