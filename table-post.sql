-- Table: public.post

-- DROP TABLE public.post;

CREATE TABLE IF NOT EXISTS public.post
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    title character varying COLLATE pg_catalog."default" NOT NULL,
    content character varying COLLATE pg_catalog."default" NOT NULL,
    tags character varying COLLATE pg_catalog."default" NOT NULL,
    published boolean NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE public.post
    OWNER to postgres;