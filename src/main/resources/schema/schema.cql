CREATE KEYSPACE IF NOT EXISTS demo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
CREATE TABLE IF NOT EXISTS demo.group (
    name text PRIMARY KEY,
    original_name text
) WITH comment='group summary';

CREATE TABLE IF NOT EXISTS demo.group_member (
    group_name text,
    state text,
    member_id text,
    last_updated_time TIMESTAMP,
    last_updated_reason text,
    PRIMARY KEY (group_name, state, member_id)
) WITH CLUSTERING ORDER BY (state ASC);

CREATE INDEX IF NOT EXISTS group_memeber_idx1 ON demo.group_member (member_id);
CREATE INDEX IF NOT EXISTS group_memeber_idx2 ON demo.group_member (last_updated_time);

