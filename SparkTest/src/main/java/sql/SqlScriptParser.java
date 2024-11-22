// Generated from /Users/tianyipeng/IdeaProjects/mobius-inceptor/src/main/antlr4/com/haizhi/mobius/parser/SqlScript.g4 by ANTLR 4.7
package sql;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, SELECT=15, FROM=16, ADD=17, 
		AS=18, ALL=19, DISTINCT=20, WHERE=21, GROUP=22, BY=23, GROUPING=24, SETS=25, 
		CUBE=26, ROLLUP=27, ORDER=28, HAVING=29, LIMIT=30, AT=31, OR=32, AND=33, 
		IN=34, NOT=35, NO=36, EXISTS=37, BETWEEN=38, LIKE=39, RLIKE=40, IS=41, 
		NULL=42, TRUE=43, FALSE=44, NULLS=45, ASC=46, DESC=47, FOR=48, INTERVAL=49, 
		CASE=50, WHEN=51, THEN=52, ELSE=53, END=54, JOIN=55, CROSS=56, OUTER=57, 
		INNER=58, LEFT=59, SEMI=60, RIGHT=61, FULL=62, NATURAL=63, ON=64, LATERAL=65, 
		WINDOW=66, OVER=67, PARTITION=68, RANGE=69, ROWS=70, UNBOUNDED=71, PRECEDING=72, 
		FOLLOWING=73, CURRENT=74, FIRST=75, AFTER=76, LAST=77, ROW=78, WITH=79, 
		VALUES=80, CREATE=81, TABLE=82, VIEW=83, REPLACE=84, INSERT=85, DELETE=86, 
		INTO=87, DESCRIBE=88, EXPLAIN=89, FORMAT=90, LOGICAL=91, CODEGEN=92, COST=93, 
		CAST=94, SHOW=95, TABLES=96, COLUMNS=97, COLUMN=98, USE=99, PARTITIONS=100, 
		FUNCTIONS=101, DROP=102, UNION=103, EXCEPT=104, SETMINUS=105, INTERSECT=106, 
		TO=107, TABLESAMPLE=108, STRATIFY=109, ALTER=110, RENAME=111, ARRAY=112, 
		MAP=113, STRUCT=114, COMMENT=115, SET=116, RESET=117, DATA=118, START=119, 
		TRANSACTION=120, COMMIT=121, ROLLBACK=122, MACRO=123, IGNORE=124, IF=125, 
		EQ=126, NSEQ=127, NEQ=128, NEQJ=129, LT=130, LTE=131, GT=132, GTE=133, 
		PLUS=134, MINUS=135, ASTERISK=136, SLASH=137, PERCENT=138, DIV=139, TILDE=140, 
		AMPERSAND=141, PIPE=142, HAT=143, PERCENTLIT=144, BUCKET=145, OUT=146, 
		OF=147, SORT=148, CLUSTER=149, DISTRIBUTE=150, OVERWRITE=151, TRANSFORM=152, 
		REDUCE=153, USING=154, SERDE=155, SERDEPROPERTIES=156, RECORDREADER=157, 
		RECORDWRITER=158, DELIMITED=159, FIELDS=160, TERMINATED=161, COLLECTION=162, 
		ITEMS=163, KEYS=164, ESCAPED=165, LINES=166, SEPARATED=167, FUNCTION=168, 
		EXTENDED=169, REFRESH=170, CLEAR=171, CACHE=172, UNCACHE=173, LAZY=174, 
		FORMATTED=175, GLOBAL=176, TEMPORARY=177, OUTPUT=178, OPTIONS=179, UNSET=180, 
		TBLPROPERTIES=181, DBPROPERTIES=182, BUCKETS=183, SKEWED=184, STORED=185, 
		DIRECTORIES=186, LOCATION=187, EXCHANGE=188, ARCHIVE=189, UNARCHIVE=190, 
		FILEFORMAT=191, TOUCH=192, COMPACT=193, CONCATENATE=194, CHANGE=195, CASCADE=196, 
		RESTRICT=197, CLUSTERED=198, SORTED=199, PURGE=200, INPUTFORMAT=201, OUTPUTFORMAT=202, 
		DATABASE=203, DATABASES=204, DFS=205, TRUNCATE=206, ANALYZE=207, COMPUTE=208, 
		LIST=209, STATISTICS=210, PARTITIONED=211, EXTERNAL=212, DEFINED=213, 
		REVOKE=214, GRANT=215, LOCK=216, UNLOCK=217, MSCK=218, REPAIR=219, RECOVER=220, 
		EXPORT=221, IMPORT=222, LOAD=223, ROLE=224, ROLES=225, COMPACTIONS=226, 
		PRINCIPALS=227, TRANSACTIONS=228, INDEX=229, INDEXES=230, LOCKS=231, OPTION=232, 
		ANTI=233, LOCAL=234, INPATH=235, CURRENT_DATE=236, CURRENT_TIMESTAMP=237, 
		CALL=238, WRITE=239, VAR=240, TRAIN=241, PREDICT=242, STRING=243, BIGINT_LITERAL=244, 
		SMALLINT_LITERAL=245, TINYINT_LITERAL=246, BYTELENGTH_LITERAL=247, INTEGER_VALUE=248, 
		DECIMAL_VALUE=249, DOUBLE_LITERAL=250, BIGDECIMAL_LITERAL=251, IDENTIFIER=252, 
		BACKQUOTED_IDENTIFIER=253, SQUARE_BRACKET_IDENTIFIER=254, SHELL_COMMENT=255, 
		SIMPLE_COMMENT=256, BRACKETED_EMPTY_COMMENT=257, BRACKETED_COMMENT=258, 
		WS=259, UNRECOGNIZED=260, DELIMITER=261;
	public static final int
		RULE_sqlScript = 0, RULE_mlStatement = 1, RULE_trainStatement = 2, RULE_predictStatement = 3, 
		RULE_variableDefined = 4, RULE_tempTable = 5, RULE_udtStatement = 6, RULE_udtChainExpression = 7, 
		RULE_udtExpression = 8, RULE_udtTableList = 9, RULE_jsonValue = 10, RULE_obj = 11, 
		RULE_pair = 12, RULE_outputTable = 13, RULE_singleStatement = 14, RULE_singleExpression = 15, 
		RULE_singleTableIdentifier = 16, RULE_singleFunctionIdentifier = 17, RULE_singleDataType = 18, 
		RULE_statement = 19, RULE_unsupportedHiveNativeCommands = 20, RULE_createTableHeader = 21, 
		RULE_bucketSpec = 22, RULE_skewSpec = 23, RULE_locationSpec = 24, RULE_query = 25, 
		RULE_insertInto = 26, RULE_partitionSpecLocation = 27, RULE_partitionSpec = 28, 
		RULE_partitionVal = 29, RULE_describeFuncName = 30, RULE_describeColName = 31, 
		RULE_ctes = 32, RULE_namedQuery = 33, RULE_tableProvider = 34, RULE_tablePropertyList = 35, 
		RULE_tableProperty = 36, RULE_tablePropertyKey = 37, RULE_tablePropertyValue = 38, 
		RULE_constantList = 39, RULE_nestedConstantList = 40, RULE_createFileFormat = 41, 
		RULE_fileFormat = 42, RULE_storageHandler = 43, RULE_resource = 44, RULE_queryNoWith = 45, 
		RULE_queryOrganization = 46, RULE_multiInsertQueryBody = 47, RULE_queryTerm = 48, 
		RULE_queryPrimary = 49, RULE_sortItem = 50, RULE_querySpecification = 51, 
		RULE_hint = 52, RULE_hintStatement = 53, RULE_fromClause = 54, RULE_aggregation = 55, 
		RULE_groupingSet = 56, RULE_lateralView = 57, RULE_setQuantifier = 58, 
		RULE_relation = 59, RULE_joinRelation = 60, RULE_joinType = 61, RULE_joinCriteria = 62, 
		RULE_sample = 63, RULE_identifierList = 64, RULE_identifierSeq = 65, RULE_orderedIdentifierList = 66, 
		RULE_orderedIdentifier = 67, RULE_identifierCommentList = 68, RULE_identifierComment = 69, 
		RULE_relationPrimary = 70, RULE_inlineTable = 71, RULE_rowFormat = 72, 
		RULE_tableIdentifier = 73, RULE_functionIdentifier = 74, RULE_namedExpression = 75, 
		RULE_namedExpressionSeq = 76, RULE_expression = 77, RULE_booleanExpression = 78, 
		RULE_predicated = 79, RULE_predicate = 80, RULE_valueExpression = 81, 
		RULE_primaryExpression = 82, RULE_constant = 83, RULE_comparisonOperator = 84, 
		RULE_arithmeticOperator = 85, RULE_predicateOperator = 86, RULE_booleanValue = 87, 
		RULE_interval = 88, RULE_intervalField = 89, RULE_intervalValue = 90, 
		RULE_colPosition = 91, RULE_dataType = 92, RULE_colTypeList = 93, RULE_colType = 94, 
		RULE_complexColTypeList = 95, RULE_complexColType = 96, RULE_whenClause = 97, 
		RULE_windows = 98, RULE_namedWindow = 99, RULE_windowSpec = 100, RULE_windowFrame = 101, 
		RULE_frameBound = 102, RULE_qualifiedName = 103, RULE_identifier = 104, 
		RULE_strictIdentifier = 105, RULE_quotedIdentifier = 106, RULE_number = 107, 
		RULE_nonReserved = 108;
	public static final String[] ruleNames = {
		"sqlScript", "mlStatement", "trainStatement", "predictStatement", "variableDefined", 
		"tempTable", "udtStatement", "udtChainExpression", "udtExpression", "udtTableList", 
		"jsonValue", "obj", "pair", "outputTable", "singleStatement", "singleExpression", 
		"singleTableIdentifier", "singleFunctionIdentifier", "singleDataType", 
		"statement", "unsupportedHiveNativeCommands", "createTableHeader", "bucketSpec", 
		"skewSpec", "locationSpec", "query", "insertInto", "partitionSpecLocation", 
		"partitionSpec", "partitionVal", "describeFuncName", "describeColName", 
		"ctes", "namedQuery", "tableProvider", "tablePropertyList", "tableProperty", 
		"tablePropertyKey", "tablePropertyValue", "constantList", "nestedConstantList", 
		"createFileFormat", "fileFormat", "storageHandler", "resource", "queryNoWith", 
		"queryOrganization", "multiInsertQueryBody", "queryTerm", "queryPrimary", 
		"sortItem", "querySpecification", "hint", "hintStatement", "fromClause", 
		"aggregation", "groupingSet", "lateralView", "setQuantifier", "relation", 
		"joinRelation", "joinType", "joinCriteria", "sample", "identifierList", 
		"identifierSeq", "orderedIdentifierList", "orderedIdentifier", "identifierCommentList", 
		"identifierComment", "relationPrimary", "inlineTable", "rowFormat", "tableIdentifier", 
		"functionIdentifier", "namedExpression", "namedExpressionSeq", "expression", 
		"booleanExpression", "predicated", "predicate", "valueExpression", "primaryExpression", 
		"constant", "comparisonOperator", "arithmeticOperator", "predicateOperator", 
		"booleanValue", "interval", "intervalField", "intervalValue", "colPosition", 
		"dataType", "colTypeList", "colType", "complexColTypeList", "complexColType", 
		"whenClause", "windows", "namedWindow", "windowSpec", "windowFrame", "frameBound", 
		"qualifiedName", "identifier", "strictIdentifier", "quotedIdentifier", 
		"number", "nonReserved"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'->'", "'('", "')'", "'{'", "','", "'}'", "':'", "'.'", "'/*+'", 
		"'*/'", "'/?'", "'?/'", "'['", "']'", "'SELECT'", "'FROM'", "'ADD'", "'AS'", 
		"'ALL'", "'DISTINCT'", "'WHERE'", "'GROUP'", "'BY'", "'GROUPING'", "'SETS'", 
		"'CUBE'", "'ROLLUP'", "'ORDER'", "'HAVING'", "'LIMIT'", "'AT'", "'OR'", 
		"'AND'", "'IN'", null, "'NO'", "'EXISTS'", "'BETWEEN'", "'LIKE'", null, 
		"'IS'", "'NULL'", "'TRUE'", "'FALSE'", "'NULLS'", "'ASC'", "'DESC'", "'FOR'", 
		"'INTERVAL'", "'CASE'", "'WHEN'", "'THEN'", "'ELSE'", "'END'", "'JOIN'", 
		"'CROSS'", "'OUTER'", "'INNER'", "'LEFT'", "'SEMI'", "'RIGHT'", "'FULL'", 
		"'NATURAL'", "'ON'", "'LATERAL'", "'WINDOW'", "'OVER'", "'PARTITION'", 
		"'RANGE'", "'ROWS'", "'UNBOUNDED'", "'PRECEDING'", "'FOLLOWING'", "'CURRENT'", 
		"'FIRST'", "'AFTER'", "'LAST'", "'ROW'", "'WITH'", "'VALUES'", "'CREATE'", 
		"'TABLE'", "'VIEW'", "'REPLACE'", "'INSERT'", "'DELETE'", "'INTO'", "'DESCRIBE'", 
		"'EXPLAIN'", "'FORMAT'", "'LOGICAL'", "'CODEGEN'", "'COST'", "'CAST'", 
		"'SHOW'", "'TABLES'", "'COLUMNS'", "'COLUMN'", "'USE'", "'PARTITIONS'", 
		"'FUNCTIONS'", "'DROP'", "'UNION'", "'EXCEPT'", "'MINUS'", "'INTERSECT'", 
		"'TO'", "'TABLESAMPLE'", "'STRATIFY'", "'ALTER'", "'RENAME'", "'ARRAY'", 
		"'MAP'", "'STRUCT'", "'COMMENT'", "'SET'", "'RESET'", "'DATA'", "'START'", 
		"'TRANSACTION'", "'COMMIT'", "'ROLLBACK'", "'MACRO'", "'IGNORE'", "'IF'", 
		null, "'<=>'", "'<>'", "'!='", "'<'", null, "'>'", null, "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'DIV'", "'~'", "'&'", "'|'", "'^'", "'PERCENT'", 
		"'BUCKET'", "'OUT'", "'OF'", "'SORT'", "'CLUSTER'", "'DISTRIBUTE'", "'OVERWRITE'", 
		"'TRANSFORM'", "'REDUCE'", "'USING'", "'SERDE'", "'SERDEPROPERTIES'", 
		"'RECORDREADER'", "'RECORDWRITER'", "'DELIMITED'", "'FIELDS'", "'TERMINATED'", 
		"'COLLECTION'", "'ITEMS'", "'KEYS'", "'ESCAPED'", "'LINES'", "'SEPARATED'", 
		"'FUNCTION'", "'EXTENDED'", "'REFRESH'", "'CLEAR'", "'CACHE'", "'UNCACHE'", 
		"'LAZY'", "'FORMATTED'", "'GLOBAL'", null, "'OUTPUT'", "'OPTIONS'", "'UNSET'", 
		"'TBLPROPERTIES'", "'DBPROPERTIES'", "'BUCKETS'", "'SKEWED'", "'STORED'", 
		"'DIRECTORIES'", "'LOCATION'", "'EXCHANGE'", "'ARCHIVE'", "'UNARCHIVE'", 
		"'FILEFORMAT'", "'TOUCH'", "'COMPACT'", "'CONCATENATE'", "'CHANGE'", "'CASCADE'", 
		"'RESTRICT'", "'CLUSTERED'", "'SORTED'", "'PURGE'", "'INPUTFORMAT'", "'OUTPUTFORMAT'", 
		null, null, "'DFS'", "'TRUNCATE'", "'ANALYZE'", "'COMPUTE'", "'LIST'", 
		"'STATISTICS'", "'PARTITIONED'", "'EXTERNAL'", "'DEFINED'", "'REVOKE'", 
		"'GRANT'", "'LOCK'", "'UNLOCK'", "'MSCK'", "'REPAIR'", "'RECOVER'", "'EXPORT'", 
		"'IMPORT'", "'LOAD'", "'ROLE'", "'ROLES'", "'COMPACTIONS'", "'PRINCIPALS'", 
		"'TRANSACTIONS'", "'INDEX'", "'INDEXES'", "'LOCKS'", "'OPTION'", "'ANTI'", 
		"'LOCAL'", "'INPATH'", "'CURRENT_DATE'", "'CURRENT_TIMESTAMP'", "'CALL'", 
		"'WRITE'", "'VAR'", "'TRAIN'", "'PREDICT'", null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "'/**/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "SELECT", "FROM", "ADD", "AS", "ALL", "DISTINCT", "WHERE", 
		"GROUP", "BY", "GROUPING", "SETS", "CUBE", "ROLLUP", "ORDER", "HAVING", 
		"LIMIT", "AT", "OR", "AND", "IN", "NOT", "NO", "EXISTS", "BETWEEN", "LIKE", 
		"RLIKE", "IS", "NULL", "TRUE", "FALSE", "NULLS", "ASC", "DESC", "FOR", 
		"INTERVAL", "CASE", "WHEN", "THEN", "ELSE", "END", "JOIN", "CROSS", "OUTER", 
		"INNER", "LEFT", "SEMI", "RIGHT", "FULL", "NATURAL", "ON", "LATERAL", 
		"WINDOW", "OVER", "PARTITION", "RANGE", "ROWS", "UNBOUNDED", "PRECEDING", 
		"FOLLOWING", "CURRENT", "FIRST", "AFTER", "LAST", "ROW", "WITH", "VALUES", 
		"CREATE", "TABLE", "VIEW", "REPLACE", "INSERT", "DELETE", "INTO", "DESCRIBE", 
		"EXPLAIN", "FORMAT", "LOGICAL", "CODEGEN", "COST", "CAST", "SHOW", "TABLES", 
		"COLUMNS", "COLUMN", "USE", "PARTITIONS", "FUNCTIONS", "DROP", "UNION", 
		"EXCEPT", "SETMINUS", "INTERSECT", "TO", "TABLESAMPLE", "STRATIFY", "ALTER", 
		"RENAME", "ARRAY", "MAP", "STRUCT", "COMMENT", "SET", "RESET", "DATA", 
		"START", "TRANSACTION", "COMMIT", "ROLLBACK", "MACRO", "IGNORE", "IF", 
		"EQ", "NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", "PLUS", "MINUS", 
		"ASTERISK", "SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", "PIPE", "HAT", 
		"PERCENTLIT", "BUCKET", "OUT", "OF", "SORT", "CLUSTER", "DISTRIBUTE", 
		"OVERWRITE", "TRANSFORM", "REDUCE", "USING", "SERDE", "SERDEPROPERTIES", 
		"RECORDREADER", "RECORDWRITER", "DELIMITED", "FIELDS", "TERMINATED", "COLLECTION", 
		"ITEMS", "KEYS", "ESCAPED", "LINES", "SEPARATED", "FUNCTION", "EXTENDED", 
		"REFRESH", "CLEAR", "CACHE", "UNCACHE", "LAZY", "FORMATTED", "GLOBAL", 
		"TEMPORARY", "OUTPUT", "OPTIONS", "UNSET", "TBLPROPERTIES", "DBPROPERTIES", 
		"BUCKETS", "SKEWED", "STORED", "DIRECTORIES", "LOCATION", "EXCHANGE", 
		"ARCHIVE", "UNARCHIVE", "FILEFORMAT", "TOUCH", "COMPACT", "CONCATENATE", 
		"CHANGE", "CASCADE", "RESTRICT", "CLUSTERED", "SORTED", "PURGE", "INPUTFORMAT", 
		"OUTPUTFORMAT", "DATABASE", "DATABASES", "DFS", "TRUNCATE", "ANALYZE", 
		"COMPUTE", "LIST", "STATISTICS", "PARTITIONED", "EXTERNAL", "DEFINED", 
		"REVOKE", "GRANT", "LOCK", "UNLOCK", "MSCK", "REPAIR", "RECOVER", "EXPORT", 
		"IMPORT", "LOAD", "ROLE", "ROLES", "COMPACTIONS", "PRINCIPALS", "TRANSACTIONS", 
		"INDEX", "INDEXES", "LOCKS", "OPTION", "ANTI", "LOCAL", "INPATH", "CURRENT_DATE", 
		"CURRENT_TIMESTAMP", "CALL", "WRITE", "VAR", "TRAIN", "PREDICT", "STRING", 
		"BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", "BYTELENGTH_LITERAL", 
		"INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", 
		"IDENTIFIER", "BACKQUOTED_IDENTIFIER", "SQUARE_BRACKET_IDENTIFIER", "SHELL_COMMENT", 
		"SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", "WS", 
		"UNRECOGNIZED", "DELIMITER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SqlScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  public boolean isValidDecimal() {
	    int nextChar = _input.LA(1);
	    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
	      nextChar == '_') {
	      return false;
	    } else {
	      return true;
	    }
	  }

	public SqlScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SqlScriptContext extends ParserRuleContext {
		public OutputTableContext outputTable() {
			return getRuleContext(OutputTableContext.class,0);
		}
		public MlStatementContext mlStatement() {
			return getRuleContext(MlStatementContext.class,0);
		}
		public UdtStatementContext udtStatement() {
			return getRuleContext(UdtStatementContext.class,0);
		}
		public List<TempTableContext> tempTable() {
			return getRuleContexts(TempTableContext.class);
		}
		public TempTableContext tempTable(int i) {
			return getRuleContext(TempTableContext.class,i);
		}
		public List<VariableDefinedContext> variableDefined() {
			return getRuleContexts(VariableDefinedContext.class);
		}
		public VariableDefinedContext variableDefined(int i) {
			return getRuleContext(VariableDefinedContext.class,i);
		}
		public SqlScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlScript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSqlScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSqlScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSqlScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlScriptContext sqlScript() throws RecognitionException {
		SqlScriptContext _localctx = new SqlScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlScript);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(220);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TEMPORARY:
						{
						setState(218);
						tempTable();
						}
						break;
					case VAR:
						{
						setState(219);
						variableDefined();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case JOIN:
			case CROSS:
			case OUTER:
			case INNER:
			case LEFT:
			case SEMI:
			case RIGHT:
			case FULL:
			case NATURAL:
			case ON:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case UNION:
			case EXCEPT:
			case SETMINUS:
			case INTERSECT:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OUTPUT:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case ANTI:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
			case SQUARE_BRACKET_IDENTIFIER:
				{
				setState(225);
				outputTable();
				}
				break;
			case TRAIN:
				{
				setState(226);
				mlStatement();
				}
				break;
			case CALL:
				{
				setState(227);
				udtStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MlStatementContext extends ParserRuleContext {
		public TrainStatementContext trainStatement() {
			return getRuleContext(TrainStatementContext.class,0);
		}
		public PredictStatementContext predictStatement() {
			return getRuleContext(PredictStatementContext.class,0);
		}
		public MlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterMlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitMlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitMlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MlStatementContext mlStatement() throws RecognitionException {
		MlStatementContext _localctx = new MlStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			trainStatement();
			setState(231);
			predictStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TrainStatementContext extends ParserRuleContext {
		public IdentifierContext tableName;
		public IdentifierContext mlModelName;
		public IdentifierContext paramName;
		public TerminalNode TRAIN() { return getToken(SqlScriptParser.TRAIN, 0); }
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OPTION() { return getToken(SqlScriptParser.OPTION, 0); }
		public TrainStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trainStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTrainStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTrainStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTrainStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrainStatementContext trainStatement() throws RecognitionException {
		TrainStatementContext _localctx = new TrainStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_trainStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(TRAIN);
			setState(234);
			((TrainStatementContext)_localctx).tableName = identifier();
			setState(235);
			match(WITH);
			setState(236);
			((TrainStatementContext)_localctx).mlModelName = identifier();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPTION) {
				{
				setState(237);
				match(OPTION);
				setState(238);
				((TrainStatementContext)_localctx).paramName = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredictStatementContext extends ParserRuleContext {
		public IdentifierContext tableName;
		public IdentifierContext mlModelName;
		public IdentifierContext paramName;
		public NamedExpressionSeqContext fieldList;
		public TerminalNode PREDICT() { return getToken(SqlScriptParser.PREDICT, 0); }
		public TerminalNode FIELDS() { return getToken(SqlScriptParser.FIELDS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public NamedExpressionSeqContext namedExpressionSeq() {
			return getRuleContext(NamedExpressionSeqContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public TerminalNode OPTION() { return getToken(SqlScriptParser.OPTION, 0); }
		public PredictStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predictStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPredictStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPredictStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPredictStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredictStatementContext predictStatement() throws RecognitionException {
		PredictStatementContext _localctx = new PredictStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_predictStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(PREDICT);
			setState(242);
			((PredictStatementContext)_localctx).tableName = identifier();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(243);
				match(WITH);
				setState(244);
				((PredictStatementContext)_localctx).mlModelName = identifier();
				}
			}

			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPTION) {
				{
				setState(247);
				match(OPTION);
				setState(248);
				((PredictStatementContext)_localctx).paramName = identifier();
				}
			}

			setState(251);
			match(FIELDS);
			setState(252);
			((PredictStatementContext)_localctx).fieldList = namedExpressionSeq();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinedContext extends ParserRuleContext {
		public IdentifierContext variableName;
		public TerminalNode VAR() { return getToken(SqlScriptParser.VAR, 0); }
		public TerminalNode EQ() { return getToken(SqlScriptParser.EQ, 0); }
		public JsonValueContext jsonValue() {
			return getRuleContext(JsonValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VariableDefinedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefined; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterVariableDefined(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitVariableDefined(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitVariableDefined(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinedContext variableDefined() throws RecognitionException {
		VariableDefinedContext _localctx = new VariableDefinedContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDefined);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(254);
			match(VAR);
			setState(255);
			((VariableDefinedContext)_localctx).variableName = identifier();
			setState(256);
			match(EQ);
			setState(257);
			jsonValue();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TempTableContext extends ParserRuleContext {
		public IdentifierContext tb;
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode EQ() { return getToken(SqlScriptParser.EQ, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public MlStatementContext mlStatement() {
			return getRuleContext(MlStatementContext.class,0);
		}
		public TempTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTempTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTempTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTempTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TempTableContext tempTable() throws RecognitionException {
		TempTableContext _localctx = new TempTableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tempTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(259);
			match(TEMPORARY);
			setState(260);
			((TempTableContext)_localctx).tb = identifier();
			setState(261);
			match(EQ);
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case SELECT:
			case FROM:
			case WITH:
			case VALUES:
			case TABLE:
			case INSERT:
			case MAP:
			case REDUCE:
				{
				setState(262);
				query();
				}
				break;
			case TRAIN:
				{
				setState(263);
				mlStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtStatementContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(SqlScriptParser.CALL, 0); }
		public UdtChainExpressionContext udtChainExpression() {
			return getRuleContext(UdtChainExpressionContext.class,0);
		}
		public UdtStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUdtStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUdtStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUdtStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtStatementContext udtStatement() throws RecognitionException {
		UdtStatementContext _localctx = new UdtStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_udtStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(CALL);
			setState(267);
			udtChainExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtChainExpressionContext extends ParserRuleContext {
		public NamedExpressionSeqContext fieldList;
		public List<UdtExpressionContext> udtExpression() {
			return getRuleContexts(UdtExpressionContext.class);
		}
		public UdtExpressionContext udtExpression(int i) {
			return getRuleContext(UdtExpressionContext.class,i);
		}
		public TerminalNode WRITE() { return getToken(SqlScriptParser.WRITE, 0); }
		public NamedExpressionSeqContext namedExpressionSeq() {
			return getRuleContext(NamedExpressionSeqContext.class,0);
		}
		public UdtChainExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtChainExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUdtChainExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUdtChainExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUdtChainExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtChainExpressionContext udtChainExpression() throws RecognitionException {
		UdtChainExpressionContext _localctx = new UdtChainExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_udtChainExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			udtExpression();
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(270);
					match(T__0);
					setState(271);
					udtExpression();
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(277);
			match(T__0);
			setState(278);
			match(WRITE);
			setState(279);
			match(T__1);
			setState(280);
			((UdtChainExpressionContext)_localctx).fieldList = namedExpressionSeq();
			setState(281);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtExpressionContext extends ParserRuleContext {
		public IdentifierContext udtName;
		public UdtTableListContext tableList;
		public IdentifierContext paramName;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OPTION() { return getToken(SqlScriptParser.OPTION, 0); }
		public UdtTableListContext udtTableList() {
			return getRuleContext(UdtTableListContext.class,0);
		}
		public UdtExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUdtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUdtExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUdtExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtExpressionContext udtExpression() throws RecognitionException {
		UdtExpressionContext _localctx = new UdtExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_udtExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			((UdtExpressionContext)_localctx).udtName = identifier();
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(284);
				((UdtExpressionContext)_localctx).tableList = udtTableList();
				}
				break;
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPTION) {
				{
				setState(287);
				match(OPTION);
				setState(288);
				((UdtExpressionContext)_localctx).paramName = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtTableListContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public UdtTableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtTableList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUdtTableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUdtTableList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUdtTableList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtTableListContext udtTableList() throws RecognitionException {
		UdtTableListContext _localctx = new UdtTableListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_udtTableList);
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(T__1);
				setState(292);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				identifierList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				identifierSeq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JsonValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public TerminalNode SQUARE_BRACKET_IDENTIFIER() { return getToken(SqlScriptParser.SQUARE_BRACKET_IDENTIFIER, 0); }
		public TerminalNode TRUE() { return getToken(SqlScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SqlScriptParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(SqlScriptParser.NULL, 0); }
		public JsonValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterJsonValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitJsonValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitJsonValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonValueContext jsonValue() throws RecognitionException {
		JsonValueContext _localctx = new JsonValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jsonValue);
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				match(STRING);
				}
				break;
			case MINUS:
			case BIGINT_LITERAL:
			case SMALLINT_LITERAL:
			case TINYINT_LITERAL:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
			case DOUBLE_LITERAL:
			case BIGDECIMAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				number();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				obj();
				}
				break;
			case SQUARE_BRACKET_IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				match(SQUARE_BRACKET_IDENTIFIER);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				match(FALSE);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 7);
				{
				setState(303);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjContext extends ParserRuleContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_obj);
		int _la;
		try {
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				match(T__3);
				setState(307);
				pair();
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(308);
					match(T__4);
					setState(309);
					pair();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				match(T__3);
				setState(318);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public JsonValueContext jsonValue() {
			return getRuleContext(JsonValueContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(STRING);
			setState(322);
			match(T__6);
			setState(323);
			jsonValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputTableContext extends ParserRuleContext {
		public IdentifierContext tb;
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode OUTPUT() { return getToken(SqlScriptParser.OUTPUT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public OutputTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterOutputTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitOutputTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitOutputTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputTableContext outputTable() throws RecognitionException {
		OutputTableContext _localctx = new OutputTableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_outputTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUTPUT) {
				{
				setState(325);
				match(OUTPUT);
				}
			}

			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(328);
				query();
				}
				break;
			case 2:
				{
				setState(329);
				((OutputTableContext)_localctx).tb = identifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlScriptParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			statement();
			setState(333);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleExpressionContext extends ParserRuleContext {
		public NamedExpressionContext namedExpression() {
			return getRuleContext(NamedExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlScriptParser.EOF, 0); }
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSingleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSingleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSingleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_singleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			namedExpression();
			setState(336);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTableIdentifierContext extends ParserRuleContext {
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlScriptParser.EOF, 0); }
		public SingleTableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSingleTableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSingleTableIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSingleTableIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTableIdentifierContext singleTableIdentifier() throws RecognitionException {
		SingleTableIdentifierContext _localctx = new SingleTableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_singleTableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			tableIdentifier();
			setState(339);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleFunctionIdentifierContext extends ParserRuleContext {
		public FunctionIdentifierContext functionIdentifier() {
			return getRuleContext(FunctionIdentifierContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlScriptParser.EOF, 0); }
		public SingleFunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleFunctionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSingleFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSingleFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSingleFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleFunctionIdentifierContext singleFunctionIdentifier() throws RecognitionException {
		SingleFunctionIdentifierContext _localctx = new SingleFunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_singleFunctionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			functionIdentifier();
			setState(342);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleDataTypeContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlScriptParser.EOF, 0); }
		public SingleDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSingleDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSingleDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSingleDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleDataTypeContext singleDataType() throws RecognitionException {
		SingleDataTypeContext _localctx = new SingleDataTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_singleDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			dataType();
			setState(345);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExplainContext extends StatementContext {
		public TerminalNode EXPLAIN() { return getToken(SqlScriptParser.EXPLAIN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode LOGICAL() { return getToken(SqlScriptParser.LOGICAL, 0); }
		public TerminalNode FORMATTED() { return getToken(SqlScriptParser.FORMATTED, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlScriptParser.EXTENDED, 0); }
		public TerminalNode CODEGEN() { return getToken(SqlScriptParser.CODEGEN, 0); }
		public TerminalNode COST() { return getToken(SqlScriptParser.COST, 0); }
		public ExplainContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterExplain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitExplain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitExplain(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropDatabaseContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SqlScriptParser.DROP, 0); }
		public TerminalNode DATABASE() { return getToken(SqlScriptParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlScriptParser.RESTRICT, 0); }
		public TerminalNode CASCADE() { return getToken(SqlScriptParser.CASCADE, 0); }
		public DropDatabaseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDropDatabase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDropDatabase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDropDatabase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ResetConfigurationContext extends StatementContext {
		public TerminalNode RESET() { return getToken(SqlScriptParser.RESET, 0); }
		public ResetConfigurationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterResetConfiguration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitResetConfiguration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitResetConfiguration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DescribeDatabaseContext extends StatementContext {
		public TerminalNode DATABASE() { return getToken(SqlScriptParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SqlScriptParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlScriptParser.DESCRIBE, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlScriptParser.EXTENDED, 0); }
		public DescribeDatabaseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDescribeDatabase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDescribeDatabase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDescribeDatabase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlterViewQueryContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public AlterViewQueryContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterAlterViewQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitAlterViewQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitAlterViewQuery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UseContext extends StatementContext {
		public IdentifierContext db;
		public TerminalNode USE() { return getToken(SqlScriptParser.USE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateTempViewUsingContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TableProviderContext tableProvider() {
			return getRuleContext(TableProviderContext.class,0);
		}
		public TerminalNode OR() { return getToken(SqlScriptParser.OR, 0); }
		public TerminalNode REPLACE() { return getToken(SqlScriptParser.REPLACE, 0); }
		public TerminalNode GLOBAL() { return getToken(SqlScriptParser.GLOBAL, 0); }
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public TerminalNode OPTIONS() { return getToken(SqlScriptParser.OPTIONS, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public CreateTempViewUsingContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateTempViewUsing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateTempViewUsing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateTempViewUsing(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameTableContext extends StatementContext {
		public TableIdentifierContext from;
		public TableIdentifierContext to;
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode RENAME() { return getToken(SqlScriptParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(SqlScriptParser.TO, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public List<TableIdentifierContext> tableIdentifier() {
			return getRuleContexts(TableIdentifierContext.class);
		}
		public TableIdentifierContext tableIdentifier(int i) {
			return getRuleContext(TableIdentifierContext.class,i);
		}
		public RenameTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRenameTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRenameTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRenameTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FailNativeCommandContext extends StatementContext {
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public TerminalNode ROLE() { return getToken(SqlScriptParser.ROLE, 0); }
		public UnsupportedHiveNativeCommandsContext unsupportedHiveNativeCommands() {
			return getRuleContext(UnsupportedHiveNativeCommandsContext.class,0);
		}
		public FailNativeCommandContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterFailNativeCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitFailNativeCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitFailNativeCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClearCacheContext extends StatementContext {
		public TerminalNode CLEAR() { return getToken(SqlScriptParser.CLEAR, 0); }
		public TerminalNode CACHE() { return getToken(SqlScriptParser.CACHE, 0); }
		public ClearCacheContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterClearCache(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitClearCache(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitClearCache(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowTablesContext extends StatementContext {
		public IdentifierContext db;
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(SqlScriptParser.TABLES, 0); }
		public TerminalNode FROM() { return getToken(SqlScriptParser.FROM, 0); }
		public TerminalNode IN() { return getToken(SqlScriptParser.IN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode LIKE() { return getToken(SqlScriptParser.LIKE, 0); }
		public ShowTablesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowTables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowTables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowTables(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecoverPartitionsContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode RECOVER() { return getToken(SqlScriptParser.RECOVER, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlScriptParser.PARTITIONS, 0); }
		public RecoverPartitionsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRecoverPartitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRecoverPartitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRecoverPartitions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameTablePartitionContext extends StatementContext {
		public PartitionSpecContext from;
		public PartitionSpecContext to;
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode RENAME() { return getToken(SqlScriptParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(SqlScriptParser.TO, 0); }
		public List<PartitionSpecContext> partitionSpec() {
			return getRuleContexts(PartitionSpecContext.class);
		}
		public PartitionSpecContext partitionSpec(int i) {
			return getRuleContext(PartitionSpecContext.class,i);
		}
		public RenameTablePartitionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRenameTablePartition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRenameTablePartition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRenameTablePartition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepairTableContext extends StatementContext {
		public TerminalNode MSCK() { return getToken(SqlScriptParser.MSCK, 0); }
		public TerminalNode REPAIR() { return getToken(SqlScriptParser.REPAIR, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public RepairTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRepairTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRepairTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRepairTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefreshResourceContext extends StatementContext {
		public TerminalNode REFRESH() { return getToken(SqlScriptParser.REFRESH, 0); }
		public RefreshResourceContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRefreshResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRefreshResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRefreshResource(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowCreateTableContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public ShowCreateTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowCreateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowCreateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowColumnsContext extends StatementContext {
		public IdentifierContext db;
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlScriptParser.COLUMNS, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public List<TerminalNode> FROM() { return getTokens(SqlScriptParser.FROM); }
		public TerminalNode FROM(int i) {
			return getToken(SqlScriptParser.FROM, i);
		}
		public List<TerminalNode> IN() { return getTokens(SqlScriptParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(SqlScriptParser.IN, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ShowColumnsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowColumns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowColumns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowColumns(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddTablePartitionContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SqlScriptParser.ADD, 0); }
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public List<PartitionSpecLocationContext> partitionSpecLocation() {
			return getRuleContexts(PartitionSpecLocationContext.class);
		}
		public PartitionSpecLocationContext partitionSpecLocation(int i) {
			return getRuleContext(PartitionSpecLocationContext.class,i);
		}
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public List<PartitionSpecContext> partitionSpec() {
			return getRuleContexts(PartitionSpecContext.class);
		}
		public PartitionSpecContext partitionSpec(int i) {
			return getRuleContext(PartitionSpecContext.class,i);
		}
		public AddTablePartitionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterAddTablePartition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitAddTablePartition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitAddTablePartition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefreshTableContext extends StatementContext {
		public TerminalNode REFRESH() { return getToken(SqlScriptParser.REFRESH, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public RefreshTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRefreshTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRefreshTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRefreshTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ManageResourceContext extends StatementContext {
		public Token op;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SqlScriptParser.ADD, 0); }
		public TerminalNode LIST() { return getToken(SqlScriptParser.LIST, 0); }
		public ManageResourceContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterManageResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitManageResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitManageResource(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateDatabaseContext extends StatementContext {
		public Token comment;
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode DATABASE() { return getToken(SqlScriptParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public TerminalNode DBPROPERTIES() { return getToken(SqlScriptParser.DBPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public CreateDatabaseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateDatabase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateDatabase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateDatabase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnalyzeContext extends StatementContext {
		public TerminalNode ANALYZE() { return getToken(SqlScriptParser.ANALYZE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode COMPUTE() { return getToken(SqlScriptParser.COMPUTE, 0); }
		public TerminalNode STATISTICS() { return getToken(SqlScriptParser.STATISTICS, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode FOR() { return getToken(SqlScriptParser.FOR, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlScriptParser.COLUMNS, 0); }
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public AnalyzeContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterAnalyze(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitAnalyze(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitAnalyze(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateHiveTableContext extends StatementContext {
		public ColTypeListContext columns;
		public Token comment;
		public ColTypeListContext partitionColumns;
		public CreateTableHeaderContext createTableHeader() {
			return getRuleContext(CreateTableHeaderContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlScriptParser.PARTITIONED, 0); }
		public TerminalNode BY() { return getToken(SqlScriptParser.BY, 0); }
		public BucketSpecContext bucketSpec() {
			return getRuleContext(BucketSpecContext.class,0);
		}
		public SkewSpecContext skewSpec() {
			return getRuleContext(SkewSpecContext.class,0);
		}
		public RowFormatContext rowFormat() {
			return getRuleContext(RowFormatContext.class,0);
		}
		public CreateFileFormatContext createFileFormat() {
			return getRuleContext(CreateFileFormatContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public TerminalNode TBLPROPERTIES() { return getToken(SqlScriptParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public List<ColTypeListContext> colTypeList() {
			return getRuleContexts(ColTypeListContext.class);
		}
		public ColTypeListContext colTypeList(int i) {
			return getRuleContext(ColTypeListContext.class,i);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public CreateHiveTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateHiveTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateHiveTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateHiveTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateFunctionContext extends StatementContext {
		public Token className;
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlScriptParser.FUNCTION, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode USING() { return getToken(SqlScriptParser.USING, 0); }
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public CreateFunctionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowTableContext extends StatementContext {
		public IdentifierContext db;
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlScriptParser.EXTENDED, 0); }
		public TerminalNode LIKE() { return getToken(SqlScriptParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlScriptParser.FROM, 0); }
		public TerminalNode IN() { return getToken(SqlScriptParser.IN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ShowTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetDatabasePropertiesContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode DATABASE() { return getToken(SqlScriptParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public TerminalNode DBPROPERTIES() { return getToken(SqlScriptParser.DBPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public SetDatabasePropertiesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSetDatabaseProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSetDatabaseProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSetDatabaseProperties(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateTableContext extends StatementContext {
		public TablePropertyListContext options;
		public IdentifierListContext partitionColumnNames;
		public Token comment;
		public CreateTableHeaderContext createTableHeader() {
			return getRuleContext(CreateTableHeaderContext.class,0);
		}
		public TableProviderContext tableProvider() {
			return getRuleContext(TableProviderContext.class,0);
		}
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public TerminalNode OPTIONS() { return getToken(SqlScriptParser.OPTIONS, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlScriptParser.PARTITIONED, 0); }
		public TerminalNode BY() { return getToken(SqlScriptParser.BY, 0); }
		public BucketSpecContext bucketSpec() {
			return getRuleContext(BucketSpecContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public CreateTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DescribeTableContext extends StatementContext {
		public Token option;
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SqlScriptParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlScriptParser.DESCRIBE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public DescribeColNameContext describeColName() {
			return getRuleContext(DescribeColNameContext.class,0);
		}
		public TerminalNode EXTENDED() { return getToken(SqlScriptParser.EXTENDED, 0); }
		public TerminalNode FORMATTED() { return getToken(SqlScriptParser.FORMATTED, 0); }
		public DescribeTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDescribeTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDescribeTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDescribeTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateTableLikeContext extends StatementContext {
		public TableIdentifierContext target;
		public TableIdentifierContext source;
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TerminalNode LIKE() { return getToken(SqlScriptParser.LIKE, 0); }
		public List<TableIdentifierContext> tableIdentifier() {
			return getRuleContexts(TableIdentifierContext.class);
		}
		public TableIdentifierContext tableIdentifier(int i) {
			return getRuleContext(TableIdentifierContext.class,i);
		}
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public CreateTableLikeContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateTableLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateTableLike(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateTableLike(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UncacheTableContext extends StatementContext {
		public TerminalNode UNCACHE() { return getToken(SqlScriptParser.UNCACHE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public UncacheTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUncacheTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUncacheTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUncacheTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropFunctionContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SqlScriptParser.DROP, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlScriptParser.FUNCTION, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public DropFunctionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDropFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDropFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDropFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadDataContext extends StatementContext {
		public Token path;
		public TerminalNode LOAD() { return getToken(SqlScriptParser.LOAD, 0); }
		public TerminalNode DATA() { return getToken(SqlScriptParser.DATA, 0); }
		public TerminalNode INPATH() { return getToken(SqlScriptParser.INPATH, 0); }
		public TerminalNode INTO() { return getToken(SqlScriptParser.INTO, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode LOCAL() { return getToken(SqlScriptParser.LOCAL, 0); }
		public TerminalNode OVERWRITE() { return getToken(SqlScriptParser.OVERWRITE, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public LoadDataContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterLoadData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitLoadData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitLoadData(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowPartitionsContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlScriptParser.PARTITIONS, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public ShowPartitionsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowPartitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowPartitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowPartitions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DescribeFunctionContext extends StatementContext {
		public TerminalNode FUNCTION() { return getToken(SqlScriptParser.FUNCTION, 0); }
		public DescribeFuncNameContext describeFuncName() {
			return getRuleContext(DescribeFuncNameContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SqlScriptParser.DESC, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlScriptParser.DESCRIBE, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlScriptParser.EXTENDED, 0); }
		public DescribeFunctionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDescribeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDescribeFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDescribeFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChangeColumnContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode CHANGE() { return getToken(SqlScriptParser.CHANGE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColTypeContext colType() {
			return getRuleContext(ColTypeContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode COLUMN() { return getToken(SqlScriptParser.COLUMN, 0); }
		public ColPositionContext colPosition() {
			return getRuleContext(ColPositionContext.class,0);
		}
		public ChangeColumnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterChangeColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitChangeColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitChangeColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementDefaultContext extends StatementContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public StatementDefaultContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterStatementDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitStatementDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitStatementDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TruncateTableContext extends StatementContext {
		public TerminalNode TRUNCATE() { return getToken(SqlScriptParser.TRUNCATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TruncateTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTruncateTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTruncateTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTruncateTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTableSerDeContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public TerminalNode SERDE() { return getToken(SqlScriptParser.SERDE, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlScriptParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public SetTableSerDeContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSetTableSerDe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSetTableSerDe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSetTableSerDe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateViewContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode OR() { return getToken(SqlScriptParser.OR, 0); }
		public TerminalNode REPLACE() { return getToken(SqlScriptParser.REPLACE, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public IdentifierCommentListContext identifierCommentList() {
			return getRuleContext(IdentifierCommentListContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlScriptParser.PARTITIONED, 0); }
		public TerminalNode ON() { return getToken(SqlScriptParser.ON, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode TBLPROPERTIES() { return getToken(SqlScriptParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode GLOBAL() { return getToken(SqlScriptParser.GLOBAL, 0); }
		public CreateViewContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateView(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateView(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateView(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropTablePartitionsContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode DROP() { return getToken(SqlScriptParser.DROP, 0); }
		public List<PartitionSpecContext> partitionSpec() {
			return getRuleContexts(PartitionSpecContext.class);
		}
		public PartitionSpecContext partitionSpec(int i) {
			return getRuleContext(PartitionSpecContext.class,i);
		}
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public TerminalNode PURGE() { return getToken(SqlScriptParser.PURGE, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public DropTablePartitionsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDropTablePartitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDropTablePartitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDropTablePartitions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetConfigurationContext extends StatementContext {
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public SetConfigurationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSetConfiguration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSetConfiguration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSetConfiguration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropTableContext extends StatementContext {
		public TerminalNode DROP() { return getToken(SqlScriptParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public TerminalNode PURGE() { return getToken(SqlScriptParser.PURGE, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public DropTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDropTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDropTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDropTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowDatabasesContext extends StatementContext {
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode DATABASES() { return getToken(SqlScriptParser.DATABASES, 0); }
		public TerminalNode LIKE() { return getToken(SqlScriptParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public ShowDatabasesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowDatabases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowDatabases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowDatabases(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowTblPropertiesContext extends StatementContext {
		public TableIdentifierContext table;
		public TablePropertyKeyContext key;
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlScriptParser.TBLPROPERTIES, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TablePropertyKeyContext tablePropertyKey() {
			return getRuleContext(TablePropertyKeyContext.class,0);
		}
		public ShowTblPropertiesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowTblProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowTblProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowTblProperties(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnsetTablePropertiesContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode UNSET() { return getToken(SqlScriptParser.UNSET, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlScriptParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public UnsetTablePropertiesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUnsetTableProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUnsetTableProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUnsetTableProperties(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTableLocationContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public SetTableLocationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSetTableLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSetTableLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSetTableLocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowFunctionsContext extends StatementContext {
		public Token pattern;
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlScriptParser.FUNCTIONS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SqlScriptParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public ShowFunctionsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterShowFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitShowFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitShowFunctions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CacheTableContext extends StatementContext {
		public TerminalNode CACHE() { return getToken(SqlScriptParser.CACHE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode LAZY() { return getToken(SqlScriptParser.LAZY, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public CacheTableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCacheTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCacheTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCacheTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddTableColumnsContext extends StatementContext {
		public ColTypeListContext columns;
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SqlScriptParser.ADD, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlScriptParser.COLUMNS, 0); }
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public AddTableColumnsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterAddTableColumns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitAddTableColumns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitAddTableColumns(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTablePropertiesContext extends StatementContext {
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlScriptParser.TBLPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public SetTablePropertiesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSetTableProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSetTableProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSetTableProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(953);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				_localctx = new StatementDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				query();
				}
				break;
			case 2:
				_localctx = new UseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				match(USE);
				setState(349);
				((UseContext)_localctx).db = identifier();
				}
				break;
			case 3:
				_localctx = new CreateDatabaseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(CREATE);
				setState(351);
				match(DATABASE);
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(352);
					match(IF);
					setState(353);
					match(NOT);
					setState(354);
					match(EXISTS);
					}
					break;
				}
				setState(357);
				identifier();
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(358);
					match(COMMENT);
					setState(359);
					((CreateDatabaseContext)_localctx).comment = match(STRING);
					}
				}

				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(362);
					locationSpec();
					}
				}

				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(365);
					match(WITH);
					setState(366);
					match(DBPROPERTIES);
					setState(367);
					tablePropertyList();
					}
				}

				}
				break;
			case 4:
				_localctx = new SetDatabasePropertiesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				match(ALTER);
				setState(371);
				match(DATABASE);
				setState(372);
				identifier();
				setState(373);
				match(SET);
				setState(374);
				match(DBPROPERTIES);
				setState(375);
				tablePropertyList();
				}
				break;
			case 5:
				_localctx = new DropDatabaseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(377);
				match(DROP);
				setState(378);
				match(DATABASE);
				setState(381);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(379);
					match(IF);
					setState(380);
					match(EXISTS);
					}
					break;
				}
				setState(383);
				identifier();
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CASCADE || _la==RESTRICT) {
					{
					setState(384);
					_la = _input.LA(1);
					if ( !(_la==CASCADE || _la==RESTRICT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 6:
				_localctx = new CreateTableContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(387);
				createTableHeader();
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(388);
					match(T__1);
					setState(389);
					colTypeList();
					setState(390);
					match(T__2);
					}
				}

				setState(394);
				tableProvider();
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(395);
					match(OPTIONS);
					setState(396);
					((CreateTableContext)_localctx).options = tablePropertyList();
					}
				}

				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(399);
					match(PARTITIONED);
					setState(400);
					match(BY);
					setState(401);
					((CreateTableContext)_localctx).partitionColumnNames = identifierList();
					}
				}

				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CLUSTERED) {
					{
					setState(404);
					bucketSpec();
					}
				}

				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(407);
					locationSpec();
					}
				}

				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(410);
					match(COMMENT);
					setState(411);
					((CreateTableContext)_localctx).comment = match(STRING);
					}
				}

				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << SELECT) | (1L << FROM) | (1L << AS))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (WITH - 79)) | (1L << (VALUES - 79)) | (1L << (TABLE - 79)) | (1L << (INSERT - 79)) | (1L << (MAP - 79)))) != 0) || _la==REDUCE) {
					{
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(414);
						match(AS);
						}
					}

					setState(417);
					query();
					}
				}

				}
				break;
			case 7:
				_localctx = new CreateHiveTableContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(420);
				createTableHeader();
				setState(425);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(421);
					match(T__1);
					setState(422);
					((CreateHiveTableContext)_localctx).columns = colTypeList();
					setState(423);
					match(T__2);
					}
					break;
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(427);
					match(COMMENT);
					setState(428);
					((CreateHiveTableContext)_localctx).comment = match(STRING);
					}
				}

				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(431);
					match(PARTITIONED);
					setState(432);
					match(BY);
					setState(433);
					match(T__1);
					setState(434);
					((CreateHiveTableContext)_localctx).partitionColumns = colTypeList();
					setState(435);
					match(T__2);
					}
				}

				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CLUSTERED) {
					{
					setState(439);
					bucketSpec();
					}
				}

				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SKEWED) {
					{
					setState(442);
					skewSpec();
					}
				}

				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(445);
					rowFormat();
					}
				}

				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STORED) {
					{
					setState(448);
					createFileFormat();
					}
				}

				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(451);
					locationSpec();
					}
				}

				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TBLPROPERTIES) {
					{
					setState(454);
					match(TBLPROPERTIES);
					setState(455);
					tablePropertyList();
					}
				}

				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << SELECT) | (1L << FROM) | (1L << AS))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (WITH - 79)) | (1L << (VALUES - 79)) | (1L << (TABLE - 79)) | (1L << (INSERT - 79)) | (1L << (MAP - 79)))) != 0) || _la==REDUCE) {
					{
					setState(459);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(458);
						match(AS);
						}
					}

					setState(461);
					query();
					}
				}

				}
				break;
			case 8:
				_localctx = new CreateTableLikeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(464);
				match(CREATE);
				setState(465);
				match(TABLE);
				setState(469);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(466);
					match(IF);
					setState(467);
					match(NOT);
					setState(468);
					match(EXISTS);
					}
					break;
				}
				setState(471);
				((CreateTableLikeContext)_localctx).target = tableIdentifier();
				setState(472);
				match(LIKE);
				setState(473);
				((CreateTableLikeContext)_localctx).source = tableIdentifier();
				setState(475);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(474);
					locationSpec();
					}
				}

				}
				break;
			case 9:
				_localctx = new AnalyzeContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(477);
				match(ANALYZE);
				setState(478);
				match(TABLE);
				setState(479);
				tableIdentifier();
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(480);
					partitionSpec();
					}
				}

				setState(483);
				match(COMPUTE);
				setState(484);
				match(STATISTICS);
				setState(489);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(485);
					identifier();
					}
					break;
				case 2:
					{
					setState(486);
					match(FOR);
					setState(487);
					match(COLUMNS);
					setState(488);
					identifierSeq();
					}
					break;
				}
				}
				break;
			case 10:
				_localctx = new AddTableColumnsContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(491);
				match(ALTER);
				setState(492);
				match(TABLE);
				setState(493);
				tableIdentifier();
				setState(494);
				match(ADD);
				setState(495);
				match(COLUMNS);
				setState(496);
				match(T__1);
				setState(497);
				((AddTableColumnsContext)_localctx).columns = colTypeList();
				setState(498);
				match(T__2);
				}
				break;
			case 11:
				_localctx = new RenameTableContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(500);
				match(ALTER);
				setState(501);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==VIEW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(502);
				((RenameTableContext)_localctx).from = tableIdentifier();
				setState(503);
				match(RENAME);
				setState(504);
				match(TO);
				setState(505);
				((RenameTableContext)_localctx).to = tableIdentifier();
				}
				break;
			case 12:
				_localctx = new SetTablePropertiesContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(507);
				match(ALTER);
				setState(508);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==VIEW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(509);
				tableIdentifier();
				setState(510);
				match(SET);
				setState(511);
				match(TBLPROPERTIES);
				setState(512);
				tablePropertyList();
				}
				break;
			case 13:
				_localctx = new UnsetTablePropertiesContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(514);
				match(ALTER);
				setState(515);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==VIEW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(516);
				tableIdentifier();
				setState(517);
				match(UNSET);
				setState(518);
				match(TBLPROPERTIES);
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(519);
					match(IF);
					setState(520);
					match(EXISTS);
					}
				}

				setState(523);
				tablePropertyList();
				}
				break;
			case 14:
				_localctx = new ChangeColumnContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(525);
				match(ALTER);
				setState(526);
				match(TABLE);
				setState(527);
				tableIdentifier();
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(528);
					partitionSpec();
					}
				}

				setState(531);
				match(CHANGE);
				setState(533);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(532);
					match(COLUMN);
					}
					break;
				}
				setState(535);
				identifier();
				setState(536);
				colType();
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FIRST || _la==AFTER) {
					{
					setState(537);
					colPosition();
					}
				}

				}
				break;
			case 15:
				_localctx = new SetTableSerDeContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(540);
				match(ALTER);
				setState(541);
				match(TABLE);
				setState(542);
				tableIdentifier();
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(543);
					partitionSpec();
					}
				}

				setState(546);
				match(SET);
				setState(547);
				match(SERDE);
				setState(548);
				match(STRING);
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(549);
					match(WITH);
					setState(550);
					match(SERDEPROPERTIES);
					setState(551);
					tablePropertyList();
					}
				}

				}
				break;
			case 16:
				_localctx = new SetTableSerDeContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(554);
				match(ALTER);
				setState(555);
				match(TABLE);
				setState(556);
				tableIdentifier();
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(557);
					partitionSpec();
					}
				}

				setState(560);
				match(SET);
				setState(561);
				match(SERDEPROPERTIES);
				setState(562);
				tablePropertyList();
				}
				break;
			case 17:
				_localctx = new AddTablePartitionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(564);
				match(ALTER);
				setState(565);
				match(TABLE);
				setState(566);
				tableIdentifier();
				setState(567);
				match(ADD);
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(568);
					match(IF);
					setState(569);
					match(NOT);
					setState(570);
					match(EXISTS);
					}
				}

				setState(574); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(573);
					partitionSpecLocation();
					}
					}
					setState(576); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PARTITION );
				}
				break;
			case 18:
				_localctx = new AddTablePartitionContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(578);
				match(ALTER);
				setState(579);
				match(VIEW);
				setState(580);
				tableIdentifier();
				setState(581);
				match(ADD);
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(582);
					match(IF);
					setState(583);
					match(NOT);
					setState(584);
					match(EXISTS);
					}
				}

				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(587);
					partitionSpec();
					}
					}
					setState(590); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PARTITION );
				}
				break;
			case 19:
				_localctx = new RenameTablePartitionContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(592);
				match(ALTER);
				setState(593);
				match(TABLE);
				setState(594);
				tableIdentifier();
				setState(595);
				((RenameTablePartitionContext)_localctx).from = partitionSpec();
				setState(596);
				match(RENAME);
				setState(597);
				match(TO);
				setState(598);
				((RenameTablePartitionContext)_localctx).to = partitionSpec();
				}
				break;
			case 20:
				_localctx = new DropTablePartitionsContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(600);
				match(ALTER);
				setState(601);
				match(TABLE);
				setState(602);
				tableIdentifier();
				setState(603);
				match(DROP);
				setState(606);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(604);
					match(IF);
					setState(605);
					match(EXISTS);
					}
				}

				setState(608);
				partitionSpec();
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(609);
					match(T__4);
					setState(610);
					partitionSpec();
					}
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PURGE) {
					{
					setState(616);
					match(PURGE);
					}
				}

				}
				break;
			case 21:
				_localctx = new DropTablePartitionsContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(619);
				match(ALTER);
				setState(620);
				match(VIEW);
				setState(621);
				tableIdentifier();
				setState(622);
				match(DROP);
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(623);
					match(IF);
					setState(624);
					match(EXISTS);
					}
				}

				setState(627);
				partitionSpec();
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(628);
					match(T__4);
					setState(629);
					partitionSpec();
					}
					}
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 22:
				_localctx = new SetTableLocationContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(635);
				match(ALTER);
				setState(636);
				match(TABLE);
				setState(637);
				tableIdentifier();
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(638);
					partitionSpec();
					}
				}

				setState(641);
				match(SET);
				setState(642);
				locationSpec();
				}
				break;
			case 23:
				_localctx = new RecoverPartitionsContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(644);
				match(ALTER);
				setState(645);
				match(TABLE);
				setState(646);
				tableIdentifier();
				setState(647);
				match(RECOVER);
				setState(648);
				match(PARTITIONS);
				}
				break;
			case 24:
				_localctx = new DropTableContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(650);
				match(DROP);
				setState(651);
				match(TABLE);
				setState(654);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(652);
					match(IF);
					setState(653);
					match(EXISTS);
					}
					break;
				}
				setState(656);
				tableIdentifier();
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PURGE) {
					{
					setState(657);
					match(PURGE);
					}
				}

				}
				break;
			case 25:
				_localctx = new DropTableContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(660);
				match(DROP);
				setState(661);
				match(VIEW);
				setState(664);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(662);
					match(IF);
					setState(663);
					match(EXISTS);
					}
					break;
				}
				setState(666);
				tableIdentifier();
				}
				break;
			case 26:
				_localctx = new CreateViewContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(667);
				match(CREATE);
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(668);
					match(OR);
					setState(669);
					match(REPLACE);
					}
				}

				setState(676);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GLOBAL || _la==TEMPORARY) {
					{
					setState(673);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==GLOBAL) {
						{
						setState(672);
						match(GLOBAL);
						}
					}

					setState(675);
					match(TEMPORARY);
					}
				}

				setState(678);
				match(VIEW);
				setState(682);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(679);
					match(IF);
					setState(680);
					match(NOT);
					setState(681);
					match(EXISTS);
					}
					break;
				}
				setState(684);
				tableIdentifier();
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(685);
					identifierCommentList();
					}
				}

				setState(690);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMENT) {
					{
					setState(688);
					match(COMMENT);
					setState(689);
					match(STRING);
					}
				}

				setState(695);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(692);
					match(PARTITIONED);
					setState(693);
					match(ON);
					setState(694);
					identifierList();
					}
				}

				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TBLPROPERTIES) {
					{
					setState(697);
					match(TBLPROPERTIES);
					setState(698);
					tablePropertyList();
					}
				}

				setState(701);
				match(AS);
				setState(702);
				query();
				}
				break;
			case 27:
				_localctx = new CreateTempViewUsingContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(704);
				match(CREATE);
				setState(707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR) {
					{
					setState(705);
					match(OR);
					setState(706);
					match(REPLACE);
					}
				}

				setState(710);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GLOBAL) {
					{
					setState(709);
					match(GLOBAL);
					}
				}

				setState(712);
				match(TEMPORARY);
				setState(713);
				match(VIEW);
				setState(714);
				tableIdentifier();
				setState(719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(715);
					match(T__1);
					setState(716);
					colTypeList();
					setState(717);
					match(T__2);
					}
				}

				setState(721);
				tableProvider();
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(722);
					match(OPTIONS);
					setState(723);
					tablePropertyList();
					}
				}

				}
				break;
			case 28:
				_localctx = new AlterViewQueryContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(726);
				match(ALTER);
				setState(727);
				match(VIEW);
				setState(728);
				tableIdentifier();
				setState(730);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(729);
					match(AS);
					}
				}

				setState(732);
				query();
				}
				break;
			case 29:
				_localctx = new CreateFunctionContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(734);
				match(CREATE);
				setState(736);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEMPORARY) {
					{
					setState(735);
					match(TEMPORARY);
					}
				}

				setState(738);
				match(FUNCTION);
				setState(739);
				qualifiedName();
				setState(740);
				match(AS);
				setState(741);
				((CreateFunctionContext)_localctx).className = match(STRING);
				setState(751);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(742);
					match(USING);
					setState(743);
					resource();
					setState(748);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(744);
						match(T__4);
						setState(745);
						resource();
						}
						}
						setState(750);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			case 30:
				_localctx = new DropFunctionContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(753);
				match(DROP);
				setState(755);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEMPORARY) {
					{
					setState(754);
					match(TEMPORARY);
					}
				}

				setState(757);
				match(FUNCTION);
				setState(760);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(758);
					match(IF);
					setState(759);
					match(EXISTS);
					}
					break;
				}
				setState(762);
				qualifiedName();
				}
				break;
			case 31:
				_localctx = new ExplainContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(763);
				match(EXPLAIN);
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (LOGICAL - 91)) | (1L << (CODEGEN - 91)) | (1L << (COST - 91)))) != 0) || _la==EXTENDED || _la==FORMATTED) {
					{
					setState(764);
					_la = _input.LA(1);
					if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (LOGICAL - 91)) | (1L << (CODEGEN - 91)) | (1L << (COST - 91)))) != 0) || _la==EXTENDED || _la==FORMATTED) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(767);
				statement();
				}
				break;
			case 32:
				_localctx = new ShowTablesContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(768);
				match(SHOW);
				setState(769);
				match(TABLES);
				setState(772);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(770);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(771);
					((ShowTablesContext)_localctx).db = identifier();
					}
				}

				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LIKE || _la==STRING) {
					{
					setState(775);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LIKE) {
						{
						setState(774);
						match(LIKE);
						}
					}

					setState(777);
					((ShowTablesContext)_localctx).pattern = match(STRING);
					}
				}

				}
				break;
			case 33:
				_localctx = new ShowTableContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(780);
				match(SHOW);
				setState(781);
				match(TABLE);
				setState(782);
				match(EXTENDED);
				setState(785);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(783);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(784);
					((ShowTableContext)_localctx).db = identifier();
					}
				}

				setState(787);
				match(LIKE);
				setState(788);
				((ShowTableContext)_localctx).pattern = match(STRING);
				setState(790);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(789);
					partitionSpec();
					}
				}

				}
				break;
			case 34:
				_localctx = new ShowDatabasesContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(792);
				match(SHOW);
				setState(793);
				match(DATABASES);
				setState(796);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LIKE) {
					{
					setState(794);
					match(LIKE);
					setState(795);
					((ShowDatabasesContext)_localctx).pattern = match(STRING);
					}
				}

				}
				break;
			case 35:
				_localctx = new ShowTblPropertiesContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(798);
				match(SHOW);
				setState(799);
				match(TBLPROPERTIES);
				setState(800);
				((ShowTblPropertiesContext)_localctx).table = tableIdentifier();
				setState(805);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(801);
					match(T__1);
					setState(802);
					((ShowTblPropertiesContext)_localctx).key = tablePropertyKey();
					setState(803);
					match(T__2);
					}
				}

				}
				break;
			case 36:
				_localctx = new ShowColumnsContext(_localctx);
				enterOuterAlt(_localctx, 36);
				{
				setState(807);
				match(SHOW);
				setState(808);
				match(COLUMNS);
				setState(809);
				_la = _input.LA(1);
				if ( !(_la==FROM || _la==IN) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(810);
				tableIdentifier();
				setState(813);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM || _la==IN) {
					{
					setState(811);
					_la = _input.LA(1);
					if ( !(_la==FROM || _la==IN) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(812);
					((ShowColumnsContext)_localctx).db = identifier();
					}
				}

				}
				break;
			case 37:
				_localctx = new ShowPartitionsContext(_localctx);
				enterOuterAlt(_localctx, 37);
				{
				setState(815);
				match(SHOW);
				setState(816);
				match(PARTITIONS);
				setState(817);
				tableIdentifier();
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(818);
					partitionSpec();
					}
				}

				}
				break;
			case 38:
				_localctx = new ShowFunctionsContext(_localctx);
				enterOuterAlt(_localctx, 38);
				{
				setState(821);
				match(SHOW);
				setState(823);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(822);
					identifier();
					}
					break;
				}
				setState(825);
				match(FUNCTIONS);
				setState(833);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (DIV - 139)) | (1L << (PERCENTLIT - 139)) | (1L << (BUCKET - 139)) | (1L << (OUT - 139)) | (1L << (OF - 139)) | (1L << (SORT - 139)) | (1L << (CLUSTER - 139)) | (1L << (DISTRIBUTE - 139)) | (1L << (OVERWRITE - 139)) | (1L << (TRANSFORM - 139)) | (1L << (REDUCE - 139)) | (1L << (USING - 139)) | (1L << (SERDE - 139)) | (1L << (SERDEPROPERTIES - 139)) | (1L << (RECORDREADER - 139)) | (1L << (RECORDWRITER - 139)) | (1L << (DELIMITED - 139)) | (1L << (FIELDS - 139)) | (1L << (TERMINATED - 139)) | (1L << (COLLECTION - 139)) | (1L << (ITEMS - 139)) | (1L << (KEYS - 139)) | (1L << (ESCAPED - 139)) | (1L << (LINES - 139)) | (1L << (SEPARATED - 139)) | (1L << (FUNCTION - 139)) | (1L << (EXTENDED - 139)) | (1L << (REFRESH - 139)) | (1L << (CLEAR - 139)) | (1L << (CACHE - 139)) | (1L << (UNCACHE - 139)) | (1L << (LAZY - 139)) | (1L << (FORMATTED - 139)) | (1L << (GLOBAL - 139)) | (1L << (TEMPORARY - 139)) | (1L << (OPTIONS - 139)) | (1L << (UNSET - 139)) | (1L << (TBLPROPERTIES - 139)) | (1L << (DBPROPERTIES - 139)) | (1L << (BUCKETS - 139)) | (1L << (SKEWED - 139)) | (1L << (STORED - 139)) | (1L << (DIRECTORIES - 139)) | (1L << (LOCATION - 139)) | (1L << (EXCHANGE - 139)) | (1L << (ARCHIVE - 139)) | (1L << (UNARCHIVE - 139)) | (1L << (FILEFORMAT - 139)) | (1L << (TOUCH - 139)) | (1L << (COMPACT - 139)) | (1L << (CONCATENATE - 139)) | (1L << (CHANGE - 139)) | (1L << (CASCADE - 139)) | (1L << (RESTRICT - 139)) | (1L << (CLUSTERED - 139)) | (1L << (SORTED - 139)) | (1L << (PURGE - 139)) | (1L << (INPUTFORMAT - 139)) | (1L << (OUTPUTFORMAT - 139)))) != 0) || ((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (DATABASE - 203)) | (1L << (DATABASES - 203)) | (1L << (DFS - 203)) | (1L << (TRUNCATE - 203)) | (1L << (ANALYZE - 203)) | (1L << (COMPUTE - 203)) | (1L << (LIST - 203)) | (1L << (STATISTICS - 203)) | (1L << (PARTITIONED - 203)) | (1L << (EXTERNAL - 203)) | (1L << (DEFINED - 203)) | (1L << (REVOKE - 203)) | (1L << (GRANT - 203)) | (1L << (LOCK - 203)) | (1L << (UNLOCK - 203)) | (1L << (MSCK - 203)) | (1L << (REPAIR - 203)) | (1L << (RECOVER - 203)) | (1L << (EXPORT - 203)) | (1L << (IMPORT - 203)) | (1L << (LOAD - 203)) | (1L << (ROLE - 203)) | (1L << (ROLES - 203)) | (1L << (COMPACTIONS - 203)) | (1L << (PRINCIPALS - 203)) | (1L << (TRANSACTIONS - 203)) | (1L << (INDEX - 203)) | (1L << (INDEXES - 203)) | (1L << (LOCKS - 203)) | (1L << (OPTION - 203)) | (1L << (ANTI - 203)) | (1L << (LOCAL - 203)) | (1L << (INPATH - 203)) | (1L << (CURRENT_DATE - 203)) | (1L << (CURRENT_TIMESTAMP - 203)) | (1L << (STRING - 203)) | (1L << (IDENTIFIER - 203)) | (1L << (BACKQUOTED_IDENTIFIER - 203)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 203)))) != 0)) {
					{
					setState(827);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
					case 1:
						{
						setState(826);
						match(LIKE);
						}
						break;
					}
					setState(831);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SELECT:
					case FROM:
					case ADD:
					case AS:
					case ALL:
					case DISTINCT:
					case WHERE:
					case GROUP:
					case BY:
					case GROUPING:
					case SETS:
					case CUBE:
					case ROLLUP:
					case ORDER:
					case HAVING:
					case LIMIT:
					case AT:
					case OR:
					case AND:
					case IN:
					case NOT:
					case NO:
					case EXISTS:
					case BETWEEN:
					case LIKE:
					case RLIKE:
					case IS:
					case NULL:
					case TRUE:
					case FALSE:
					case NULLS:
					case ASC:
					case DESC:
					case FOR:
					case INTERVAL:
					case CASE:
					case WHEN:
					case THEN:
					case ELSE:
					case END:
					case JOIN:
					case CROSS:
					case OUTER:
					case INNER:
					case LEFT:
					case SEMI:
					case RIGHT:
					case FULL:
					case NATURAL:
					case ON:
					case LATERAL:
					case WINDOW:
					case OVER:
					case PARTITION:
					case RANGE:
					case ROWS:
					case UNBOUNDED:
					case PRECEDING:
					case FOLLOWING:
					case CURRENT:
					case FIRST:
					case AFTER:
					case LAST:
					case ROW:
					case WITH:
					case VALUES:
					case CREATE:
					case TABLE:
					case VIEW:
					case REPLACE:
					case INSERT:
					case DELETE:
					case INTO:
					case DESCRIBE:
					case EXPLAIN:
					case FORMAT:
					case LOGICAL:
					case CODEGEN:
					case COST:
					case CAST:
					case SHOW:
					case TABLES:
					case COLUMNS:
					case COLUMN:
					case USE:
					case PARTITIONS:
					case FUNCTIONS:
					case DROP:
					case UNION:
					case EXCEPT:
					case SETMINUS:
					case INTERSECT:
					case TO:
					case TABLESAMPLE:
					case STRATIFY:
					case ALTER:
					case RENAME:
					case ARRAY:
					case MAP:
					case STRUCT:
					case COMMENT:
					case SET:
					case RESET:
					case DATA:
					case START:
					case TRANSACTION:
					case COMMIT:
					case ROLLBACK:
					case MACRO:
					case IGNORE:
					case IF:
					case DIV:
					case PERCENTLIT:
					case BUCKET:
					case OUT:
					case OF:
					case SORT:
					case CLUSTER:
					case DISTRIBUTE:
					case OVERWRITE:
					case TRANSFORM:
					case REDUCE:
					case USING:
					case SERDE:
					case SERDEPROPERTIES:
					case RECORDREADER:
					case RECORDWRITER:
					case DELIMITED:
					case FIELDS:
					case TERMINATED:
					case COLLECTION:
					case ITEMS:
					case KEYS:
					case ESCAPED:
					case LINES:
					case SEPARATED:
					case FUNCTION:
					case EXTENDED:
					case REFRESH:
					case CLEAR:
					case CACHE:
					case UNCACHE:
					case LAZY:
					case FORMATTED:
					case GLOBAL:
					case TEMPORARY:
					case OPTIONS:
					case UNSET:
					case TBLPROPERTIES:
					case DBPROPERTIES:
					case BUCKETS:
					case SKEWED:
					case STORED:
					case DIRECTORIES:
					case LOCATION:
					case EXCHANGE:
					case ARCHIVE:
					case UNARCHIVE:
					case FILEFORMAT:
					case TOUCH:
					case COMPACT:
					case CONCATENATE:
					case CHANGE:
					case CASCADE:
					case RESTRICT:
					case CLUSTERED:
					case SORTED:
					case PURGE:
					case INPUTFORMAT:
					case OUTPUTFORMAT:
					case DATABASE:
					case DATABASES:
					case DFS:
					case TRUNCATE:
					case ANALYZE:
					case COMPUTE:
					case LIST:
					case STATISTICS:
					case PARTITIONED:
					case EXTERNAL:
					case DEFINED:
					case REVOKE:
					case GRANT:
					case LOCK:
					case UNLOCK:
					case MSCK:
					case REPAIR:
					case RECOVER:
					case EXPORT:
					case IMPORT:
					case LOAD:
					case ROLE:
					case ROLES:
					case COMPACTIONS:
					case PRINCIPALS:
					case TRANSACTIONS:
					case INDEX:
					case INDEXES:
					case LOCKS:
					case OPTION:
					case ANTI:
					case LOCAL:
					case INPATH:
					case CURRENT_DATE:
					case CURRENT_TIMESTAMP:
					case IDENTIFIER:
					case BACKQUOTED_IDENTIFIER:
					case SQUARE_BRACKET_IDENTIFIER:
						{
						setState(829);
						qualifiedName();
						}
						break;
					case STRING:
						{
						setState(830);
						((ShowFunctionsContext)_localctx).pattern = match(STRING);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				break;
			case 39:
				_localctx = new ShowCreateTableContext(_localctx);
				enterOuterAlt(_localctx, 39);
				{
				setState(835);
				match(SHOW);
				setState(836);
				match(CREATE);
				setState(837);
				match(TABLE);
				setState(838);
				tableIdentifier();
				}
				break;
			case 40:
				_localctx = new DescribeFunctionContext(_localctx);
				enterOuterAlt(_localctx, 40);
				{
				setState(839);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(840);
				match(FUNCTION);
				setState(842);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(841);
					match(EXTENDED);
					}
					break;
				}
				setState(844);
				describeFuncName();
				}
				break;
			case 41:
				_localctx = new DescribeDatabaseContext(_localctx);
				enterOuterAlt(_localctx, 41);
				{
				setState(845);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(846);
				match(DATABASE);
				setState(848);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(847);
					match(EXTENDED);
					}
					break;
				}
				setState(850);
				identifier();
				}
				break;
			case 42:
				_localctx = new DescribeTableContext(_localctx);
				enterOuterAlt(_localctx, 42);
				{
				setState(851);
				_la = _input.LA(1);
				if ( !(_la==DESC || _la==DESCRIBE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(853);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(852);
					match(TABLE);
					}
					break;
				}
				setState(856);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(855);
					((DescribeTableContext)_localctx).option = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==EXTENDED || _la==FORMATTED) ) {
						((DescribeTableContext)_localctx).option = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(858);
				tableIdentifier();
				setState(860);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(859);
					partitionSpec();
					}
					break;
				}
				setState(863);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (DIV - 139)) | (1L << (PERCENTLIT - 139)) | (1L << (BUCKET - 139)) | (1L << (OUT - 139)) | (1L << (OF - 139)) | (1L << (SORT - 139)) | (1L << (CLUSTER - 139)) | (1L << (DISTRIBUTE - 139)) | (1L << (OVERWRITE - 139)) | (1L << (TRANSFORM - 139)) | (1L << (REDUCE - 139)) | (1L << (USING - 139)) | (1L << (SERDE - 139)) | (1L << (SERDEPROPERTIES - 139)) | (1L << (RECORDREADER - 139)) | (1L << (RECORDWRITER - 139)) | (1L << (DELIMITED - 139)) | (1L << (FIELDS - 139)) | (1L << (TERMINATED - 139)) | (1L << (COLLECTION - 139)) | (1L << (ITEMS - 139)) | (1L << (KEYS - 139)) | (1L << (ESCAPED - 139)) | (1L << (LINES - 139)) | (1L << (SEPARATED - 139)) | (1L << (FUNCTION - 139)) | (1L << (EXTENDED - 139)) | (1L << (REFRESH - 139)) | (1L << (CLEAR - 139)) | (1L << (CACHE - 139)) | (1L << (UNCACHE - 139)) | (1L << (LAZY - 139)) | (1L << (FORMATTED - 139)) | (1L << (GLOBAL - 139)) | (1L << (TEMPORARY - 139)) | (1L << (OPTIONS - 139)) | (1L << (UNSET - 139)) | (1L << (TBLPROPERTIES - 139)) | (1L << (DBPROPERTIES - 139)) | (1L << (BUCKETS - 139)) | (1L << (SKEWED - 139)) | (1L << (STORED - 139)) | (1L << (DIRECTORIES - 139)) | (1L << (LOCATION - 139)) | (1L << (EXCHANGE - 139)) | (1L << (ARCHIVE - 139)) | (1L << (UNARCHIVE - 139)) | (1L << (FILEFORMAT - 139)) | (1L << (TOUCH - 139)) | (1L << (COMPACT - 139)) | (1L << (CONCATENATE - 139)) | (1L << (CHANGE - 139)) | (1L << (CASCADE - 139)) | (1L << (RESTRICT - 139)) | (1L << (CLUSTERED - 139)) | (1L << (SORTED - 139)) | (1L << (PURGE - 139)) | (1L << (INPUTFORMAT - 139)) | (1L << (OUTPUTFORMAT - 139)))) != 0) || ((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (DATABASE - 203)) | (1L << (DATABASES - 203)) | (1L << (DFS - 203)) | (1L << (TRUNCATE - 203)) | (1L << (ANALYZE - 203)) | (1L << (COMPUTE - 203)) | (1L << (LIST - 203)) | (1L << (STATISTICS - 203)) | (1L << (PARTITIONED - 203)) | (1L << (EXTERNAL - 203)) | (1L << (DEFINED - 203)) | (1L << (REVOKE - 203)) | (1L << (GRANT - 203)) | (1L << (LOCK - 203)) | (1L << (UNLOCK - 203)) | (1L << (MSCK - 203)) | (1L << (REPAIR - 203)) | (1L << (RECOVER - 203)) | (1L << (EXPORT - 203)) | (1L << (IMPORT - 203)) | (1L << (LOAD - 203)) | (1L << (ROLE - 203)) | (1L << (ROLES - 203)) | (1L << (COMPACTIONS - 203)) | (1L << (PRINCIPALS - 203)) | (1L << (TRANSACTIONS - 203)) | (1L << (INDEX - 203)) | (1L << (INDEXES - 203)) | (1L << (LOCKS - 203)) | (1L << (OPTION - 203)) | (1L << (ANTI - 203)) | (1L << (LOCAL - 203)) | (1L << (INPATH - 203)) | (1L << (CURRENT_DATE - 203)) | (1L << (CURRENT_TIMESTAMP - 203)) | (1L << (IDENTIFIER - 203)) | (1L << (BACKQUOTED_IDENTIFIER - 203)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 203)))) != 0)) {
					{
					setState(862);
					describeColName();
					}
				}

				}
				break;
			case 43:
				_localctx = new RefreshTableContext(_localctx);
				enterOuterAlt(_localctx, 43);
				{
				setState(865);
				match(REFRESH);
				setState(866);
				match(TABLE);
				setState(867);
				tableIdentifier();
				}
				break;
			case 44:
				_localctx = new RefreshResourceContext(_localctx);
				enterOuterAlt(_localctx, 44);
				{
				setState(868);
				match(REFRESH);
				setState(872);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
				while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(869);
						matchWildcard();
						}
						} 
					}
					setState(874);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
				}
				}
				break;
			case 45:
				_localctx = new CacheTableContext(_localctx);
				enterOuterAlt(_localctx, 45);
				{
				setState(875);
				match(CACHE);
				setState(877);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LAZY) {
					{
					setState(876);
					match(LAZY);
					}
				}

				setState(879);
				match(TABLE);
				setState(880);
				tableIdentifier();
				setState(885);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << SELECT) | (1L << FROM) | (1L << AS))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (WITH - 79)) | (1L << (VALUES - 79)) | (1L << (TABLE - 79)) | (1L << (INSERT - 79)) | (1L << (MAP - 79)))) != 0) || _la==REDUCE) {
					{
					setState(882);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(881);
						match(AS);
						}
					}

					setState(884);
					query();
					}
				}

				}
				break;
			case 46:
				_localctx = new UncacheTableContext(_localctx);
				enterOuterAlt(_localctx, 46);
				{
				setState(887);
				match(UNCACHE);
				setState(888);
				match(TABLE);
				setState(891);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
				case 1:
					{
					setState(889);
					match(IF);
					setState(890);
					match(EXISTS);
					}
					break;
				}
				setState(893);
				tableIdentifier();
				}
				break;
			case 47:
				_localctx = new ClearCacheContext(_localctx);
				enterOuterAlt(_localctx, 47);
				{
				setState(894);
				match(CLEAR);
				setState(895);
				match(CACHE);
				}
				break;
			case 48:
				_localctx = new LoadDataContext(_localctx);
				enterOuterAlt(_localctx, 48);
				{
				setState(896);
				match(LOAD);
				setState(897);
				match(DATA);
				setState(899);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(898);
					match(LOCAL);
					}
				}

				setState(901);
				match(INPATH);
				setState(902);
				((LoadDataContext)_localctx).path = match(STRING);
				setState(904);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(903);
					match(OVERWRITE);
					}
				}

				setState(906);
				match(INTO);
				setState(907);
				match(TABLE);
				setState(908);
				tableIdentifier();
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(909);
					partitionSpec();
					}
				}

				}
				break;
			case 49:
				_localctx = new TruncateTableContext(_localctx);
				enterOuterAlt(_localctx, 49);
				{
				setState(912);
				match(TRUNCATE);
				setState(913);
				match(TABLE);
				setState(914);
				tableIdentifier();
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(915);
					partitionSpec();
					}
				}

				}
				break;
			case 50:
				_localctx = new RepairTableContext(_localctx);
				enterOuterAlt(_localctx, 50);
				{
				setState(918);
				match(MSCK);
				setState(919);
				match(REPAIR);
				setState(920);
				match(TABLE);
				setState(921);
				tableIdentifier();
				}
				break;
			case 51:
				_localctx = new ManageResourceContext(_localctx);
				enterOuterAlt(_localctx, 51);
				{
				setState(922);
				((ManageResourceContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==LIST) ) {
					((ManageResourceContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(923);
				identifier();
				setState(927);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(924);
						matchWildcard();
						}
						} 
					}
					setState(929);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				}
				}
				break;
			case 52:
				_localctx = new FailNativeCommandContext(_localctx);
				enterOuterAlt(_localctx, 52);
				{
				setState(930);
				match(SET);
				setState(931);
				match(ROLE);
				setState(935);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
				while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(932);
						matchWildcard();
						}
						} 
					}
					setState(937);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
				}
				}
				break;
			case 53:
				_localctx = new SetConfigurationContext(_localctx);
				enterOuterAlt(_localctx, 53);
				{
				setState(938);
				match(SET);
				setState(942);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(939);
						matchWildcard();
						}
						} 
					}
					setState(944);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				}
				}
				break;
			case 54:
				_localctx = new ResetConfigurationContext(_localctx);
				enterOuterAlt(_localctx, 54);
				{
				setState(945);
				match(RESET);
				}
				break;
			case 55:
				_localctx = new FailNativeCommandContext(_localctx);
				enterOuterAlt(_localctx, 55);
				{
				setState(946);
				unsupportedHiveNativeCommands();
				setState(950);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
				while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(947);
						matchWildcard();
						}
						} 
					}
					setState(952);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsupportedHiveNativeCommandsContext extends ParserRuleContext {
		public Token kw1;
		public Token kw2;
		public Token kw3;
		public Token kw4;
		public Token kw5;
		public Token kw6;
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode ROLE() { return getToken(SqlScriptParser.ROLE, 0); }
		public TerminalNode DROP() { return getToken(SqlScriptParser.DROP, 0); }
		public TerminalNode GRANT() { return getToken(SqlScriptParser.GRANT, 0); }
		public TerminalNode REVOKE() { return getToken(SqlScriptParser.REVOKE, 0); }
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode PRINCIPALS() { return getToken(SqlScriptParser.PRINCIPALS, 0); }
		public TerminalNode ROLES() { return getToken(SqlScriptParser.ROLES, 0); }
		public TerminalNode CURRENT() { return getToken(SqlScriptParser.CURRENT, 0); }
		public TerminalNode EXPORT() { return getToken(SqlScriptParser.EXPORT, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TerminalNode IMPORT() { return getToken(SqlScriptParser.IMPORT, 0); }
		public TerminalNode COMPACTIONS() { return getToken(SqlScriptParser.COMPACTIONS, 0); }
		public TerminalNode TRANSACTIONS() { return getToken(SqlScriptParser.TRANSACTIONS, 0); }
		public TerminalNode INDEXES() { return getToken(SqlScriptParser.INDEXES, 0); }
		public TerminalNode LOCKS() { return getToken(SqlScriptParser.LOCKS, 0); }
		public TerminalNode INDEX() { return getToken(SqlScriptParser.INDEX, 0); }
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode LOCK() { return getToken(SqlScriptParser.LOCK, 0); }
		public TerminalNode DATABASE() { return getToken(SqlScriptParser.DATABASE, 0); }
		public TerminalNode UNLOCK() { return getToken(SqlScriptParser.UNLOCK, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode MACRO() { return getToken(SqlScriptParser.MACRO, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode CLUSTERED() { return getToken(SqlScriptParser.CLUSTERED, 0); }
		public TerminalNode BY() { return getToken(SqlScriptParser.BY, 0); }
		public TerminalNode SORTED() { return getToken(SqlScriptParser.SORTED, 0); }
		public TerminalNode SKEWED() { return getToken(SqlScriptParser.SKEWED, 0); }
		public TerminalNode STORED() { return getToken(SqlScriptParser.STORED, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public TerminalNode DIRECTORIES() { return getToken(SqlScriptParser.DIRECTORIES, 0); }
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public TerminalNode LOCATION() { return getToken(SqlScriptParser.LOCATION, 0); }
		public TerminalNode EXCHANGE() { return getToken(SqlScriptParser.EXCHANGE, 0); }
		public TerminalNode PARTITION() { return getToken(SqlScriptParser.PARTITION, 0); }
		public TerminalNode ARCHIVE() { return getToken(SqlScriptParser.ARCHIVE, 0); }
		public TerminalNode UNARCHIVE() { return getToken(SqlScriptParser.UNARCHIVE, 0); }
		public TerminalNode TOUCH() { return getToken(SqlScriptParser.TOUCH, 0); }
		public TerminalNode COMPACT() { return getToken(SqlScriptParser.COMPACT, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode CONCATENATE() { return getToken(SqlScriptParser.CONCATENATE, 0); }
		public TerminalNode FILEFORMAT() { return getToken(SqlScriptParser.FILEFORMAT, 0); }
		public TerminalNode REPLACE() { return getToken(SqlScriptParser.REPLACE, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlScriptParser.COLUMNS, 0); }
		public TerminalNode START() { return getToken(SqlScriptParser.START, 0); }
		public TerminalNode TRANSACTION() { return getToken(SqlScriptParser.TRANSACTION, 0); }
		public TerminalNode COMMIT() { return getToken(SqlScriptParser.COMMIT, 0); }
		public TerminalNode ROLLBACK() { return getToken(SqlScriptParser.ROLLBACK, 0); }
		public TerminalNode DFS() { return getToken(SqlScriptParser.DFS, 0); }
		public TerminalNode DELETE() { return getToken(SqlScriptParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SqlScriptParser.FROM, 0); }
		public UnsupportedHiveNativeCommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsupportedHiveNativeCommands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUnsupportedHiveNativeCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUnsupportedHiveNativeCommands(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUnsupportedHiveNativeCommands(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsupportedHiveNativeCommandsContext unsupportedHiveNativeCommands() throws RecognitionException {
		UnsupportedHiveNativeCommandsContext _localctx = new UnsupportedHiveNativeCommandsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unsupportedHiveNativeCommands);
		int _la;
		try {
			setState(1125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(955);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(956);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(957);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(958);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(959);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(GRANT);
				setState(961);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					{
					setState(960);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(963);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(REVOKE);
				setState(965);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(964);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(967);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(968);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(GRANT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(969);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(970);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				setState(972);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
				case 1:
					{
					setState(971);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(GRANT);
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(974);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(975);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(PRINCIPALS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(976);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(977);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLES);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(978);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(979);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(CURRENT);
				setState(980);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(ROLES);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(981);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(EXPORT);
				setState(982);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(983);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(IMPORT);
				setState(984);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(985);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(986);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(COMPACTIONS);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(987);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(988);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(CREATE);
				setState(989);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(TABLE);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(990);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(991);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TRANSACTIONS);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(992);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(993);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEXES);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(994);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(995);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(LOCKS);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(996);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(997);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(998);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(999);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1000);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1001);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1002);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(LOCK);
				setState(1003);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1004);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(LOCK);
				setState(1005);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(DATABASE);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1006);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(UNLOCK);
				setState(1007);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1008);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(UNLOCK);
				setState(1009);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(DATABASE);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(1010);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(1011);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TEMPORARY);
				setState(1012);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(MACRO);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(1013);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(1014);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TEMPORARY);
				setState(1015);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(MACRO);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(1016);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1017);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1018);
				tableIdentifier();
				setState(1019);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(1020);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(CLUSTERED);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(1022);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1023);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1024);
				tableIdentifier();
				setState(1025);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(CLUSTERED);
				setState(1026);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(BY);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(1028);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1029);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1030);
				tableIdentifier();
				setState(1031);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(1032);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SORTED);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(1034);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1035);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1036);
				tableIdentifier();
				setState(1037);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SKEWED);
				setState(1038);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(BY);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(1040);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1041);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1042);
				tableIdentifier();
				setState(1043);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(1044);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SKEWED);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(1046);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1047);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1048);
				tableIdentifier();
				setState(1049);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(1050);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(STORED);
				setState(1051);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw5 = match(AS);
				setState(1052);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw6 = match(DIRECTORIES);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(1054);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1055);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1056);
				tableIdentifier();
				setState(1057);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SET);
				setState(1058);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SKEWED);
				setState(1059);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw5 = match(LOCATION);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(1061);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1062);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1063);
				tableIdentifier();
				setState(1064);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(EXCHANGE);
				setState(1065);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(1067);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1068);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1069);
				tableIdentifier();
				setState(1070);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(ARCHIVE);
				setState(1071);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(1073);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1074);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1075);
				tableIdentifier();
				setState(1076);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(UNARCHIVE);
				setState(1077);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(1079);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1080);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1081);
				tableIdentifier();
				setState(1082);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(TOUCH);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(1084);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1085);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1086);
				tableIdentifier();
				setState(1088);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1087);
					partitionSpec();
					}
				}

				setState(1090);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(COMPACT);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(1092);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1093);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1094);
				tableIdentifier();
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1095);
					partitionSpec();
					}
				}

				setState(1098);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(CONCATENATE);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(1100);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1101);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1102);
				tableIdentifier();
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1103);
					partitionSpec();
					}
				}

				setState(1106);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SET);
				setState(1107);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(FILEFORMAT);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(1109);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(1110);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(1111);
				tableIdentifier();
				setState(1113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1112);
					partitionSpec();
					}
				}

				setState(1115);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(REPLACE);
				setState(1116);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(COLUMNS);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(1118);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(START);
				setState(1119);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TRANSACTION);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(1120);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(COMMIT);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(1121);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ROLLBACK);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(1122);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DFS);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(1123);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DELETE);
				setState(1124);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(FROM);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateTableHeaderContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode EXTERNAL() { return getToken(SqlScriptParser.EXTERNAL, 0); }
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public CreateTableHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateTableHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateTableHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateTableHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableHeaderContext createTableHeader() throws RecognitionException {
		CreateTableHeaderContext _localctx = new CreateTableHeaderContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_createTableHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1127);
			match(CREATE);
			setState(1129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPORARY) {
				{
				setState(1128);
				match(TEMPORARY);
				}
			}

			setState(1132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTERNAL) {
				{
				setState(1131);
				match(EXTERNAL);
				}
			}

			setState(1134);
			match(TABLE);
			setState(1138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				{
				setState(1135);
				match(IF);
				setState(1136);
				match(NOT);
				setState(1137);
				match(EXISTS);
				}
				break;
			}
			setState(1140);
			tableIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BucketSpecContext extends ParserRuleContext {
		public TerminalNode CLUSTERED() { return getToken(SqlScriptParser.CLUSTERED, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlScriptParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlScriptParser.BY, i);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SqlScriptParser.INTO, 0); }
		public TerminalNode INTEGER_VALUE() { return getToken(SqlScriptParser.INTEGER_VALUE, 0); }
		public TerminalNode BUCKETS() { return getToken(SqlScriptParser.BUCKETS, 0); }
		public TerminalNode SORTED() { return getToken(SqlScriptParser.SORTED, 0); }
		public OrderedIdentifierListContext orderedIdentifierList() {
			return getRuleContext(OrderedIdentifierListContext.class,0);
		}
		public BucketSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucketSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterBucketSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitBucketSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitBucketSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BucketSpecContext bucketSpec() throws RecognitionException {
		BucketSpecContext _localctx = new BucketSpecContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bucketSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
			match(CLUSTERED);
			setState(1143);
			match(BY);
			setState(1144);
			identifierList();
			setState(1148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORTED) {
				{
				setState(1145);
				match(SORTED);
				setState(1146);
				match(BY);
				setState(1147);
				orderedIdentifierList();
				}
			}

			setState(1150);
			match(INTO);
			setState(1151);
			match(INTEGER_VALUE);
			setState(1152);
			match(BUCKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkewSpecContext extends ParserRuleContext {
		public TerminalNode SKEWED() { return getToken(SqlScriptParser.SKEWED, 0); }
		public TerminalNode BY() { return getToken(SqlScriptParser.BY, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode ON() { return getToken(SqlScriptParser.ON, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public NestedConstantListContext nestedConstantList() {
			return getRuleContext(NestedConstantListContext.class,0);
		}
		public TerminalNode STORED() { return getToken(SqlScriptParser.STORED, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public TerminalNode DIRECTORIES() { return getToken(SqlScriptParser.DIRECTORIES, 0); }
		public SkewSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSkewSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSkewSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSkewSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewSpecContext skewSpec() throws RecognitionException {
		SkewSpecContext _localctx = new SkewSpecContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_skewSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1154);
			match(SKEWED);
			setState(1155);
			match(BY);
			setState(1156);
			identifierList();
			setState(1157);
			match(ON);
			setState(1160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				{
				setState(1158);
				constantList();
				}
				break;
			case 2:
				{
				setState(1159);
				nestedConstantList();
				}
				break;
			}
			setState(1165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				{
				setState(1162);
				match(STORED);
				setState(1163);
				match(AS);
				setState(1164);
				match(DIRECTORIES);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationSpecContext extends ParserRuleContext {
		public TerminalNode LOCATION() { return getToken(SqlScriptParser.LOCATION, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public LocationSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locationSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterLocationSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitLocationSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitLocationSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationSpecContext locationSpec() throws RecognitionException {
		LocationSpecContext _localctx = new LocationSpecContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_locationSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1167);
			match(LOCATION);
			setState(1168);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public CtesContext ctes() {
			return getRuleContext(CtesContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1170);
				ctes();
				}
			}

			setState(1173);
			queryNoWith();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertIntoContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SqlScriptParser.INSERT, 0); }
		public TerminalNode OVERWRITE() { return getToken(SqlScriptParser.OVERWRITE, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public TerminalNode INTO() { return getToken(SqlScriptParser.INTO, 0); }
		public InsertIntoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertInto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterInsertInto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitInsertInto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitInsertInto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertIntoContext insertInto() throws RecognitionException {
		InsertIntoContext _localctx = new InsertIntoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_insertInto);
		int _la;
		try {
			setState(1196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1175);
				match(INSERT);
				setState(1176);
				match(OVERWRITE);
				setState(1177);
				match(TABLE);
				setState(1178);
				tableIdentifier();
				setState(1185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1179);
					partitionSpec();
					setState(1183);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IF) {
						{
						setState(1180);
						match(IF);
						setState(1181);
						match(NOT);
						setState(1182);
						match(EXISTS);
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1187);
				match(INSERT);
				setState(1188);
				match(INTO);
				setState(1190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
				case 1:
					{
					setState(1189);
					match(TABLE);
					}
					break;
				}
				setState(1192);
				tableIdentifier();
				setState(1194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1193);
					partitionSpec();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecLocationContext extends ParserRuleContext {
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public PartitionSpecLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpecLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPartitionSpecLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPartitionSpecLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPartitionSpecLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionSpecLocationContext partitionSpecLocation() throws RecognitionException {
		PartitionSpecLocationContext _localctx = new PartitionSpecLocationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_partitionSpecLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1198);
			partitionSpec();
			setState(1200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCATION) {
				{
				setState(1199);
				locationSpec();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SqlScriptParser.PARTITION, 0); }
		public List<PartitionValContext> partitionVal() {
			return getRuleContexts(PartitionValContext.class);
		}
		public PartitionValContext partitionVal(int i) {
			return getRuleContext(PartitionValContext.class,i);
		}
		public PartitionSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPartitionSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPartitionSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPartitionSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionSpecContext partitionSpec() throws RecognitionException {
		PartitionSpecContext _localctx = new PartitionSpecContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_partitionSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1202);
			match(PARTITION);
			setState(1203);
			match(T__1);
			setState(1204);
			partitionVal();
			setState(1209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1205);
				match(T__4);
				setState(1206);
				partitionVal();
				}
				}
				setState(1211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1212);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionValContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlScriptParser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public PartitionValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPartitionVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPartitionVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPartitionVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionValContext partitionVal() throws RecognitionException {
		PartitionValContext _localctx = new PartitionValContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_partitionVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1214);
			identifier();
			setState(1217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(1215);
				match(EQ);
				setState(1216);
				constant();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeFuncNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ArithmeticOperatorContext arithmeticOperator() {
			return getRuleContext(ArithmeticOperatorContext.class,0);
		}
		public PredicateOperatorContext predicateOperator() {
			return getRuleContext(PredicateOperatorContext.class,0);
		}
		public DescribeFuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeFuncName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDescribeFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDescribeFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDescribeFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescribeFuncNameContext describeFuncName() throws RecognitionException {
		DescribeFuncNameContext _localctx = new DescribeFuncNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_describeFuncName);
		try {
			setState(1224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1219);
				qualifiedName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1220);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1221);
				comparisonOperator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1222);
				arithmeticOperator();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1223);
				predicateOperator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeColNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> STRING() { return getTokens(SqlScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlScriptParser.STRING, i);
		}
		public DescribeColNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeColName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDescribeColName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDescribeColName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDescribeColName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescribeColNameContext describeColName() throws RecognitionException {
		DescribeColNameContext _localctx = new DescribeColNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_describeColName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1226);
			identifier();
			setState(1234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(1227);
				match(T__7);
				setState(1230);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
				case FROM:
				case ADD:
				case AS:
				case ALL:
				case DISTINCT:
				case WHERE:
				case GROUP:
				case BY:
				case GROUPING:
				case SETS:
				case CUBE:
				case ROLLUP:
				case ORDER:
				case HAVING:
				case LIMIT:
				case AT:
				case OR:
				case AND:
				case IN:
				case NOT:
				case NO:
				case EXISTS:
				case BETWEEN:
				case LIKE:
				case RLIKE:
				case IS:
				case NULL:
				case TRUE:
				case FALSE:
				case NULLS:
				case ASC:
				case DESC:
				case FOR:
				case INTERVAL:
				case CASE:
				case WHEN:
				case THEN:
				case ELSE:
				case END:
				case JOIN:
				case CROSS:
				case OUTER:
				case INNER:
				case LEFT:
				case SEMI:
				case RIGHT:
				case FULL:
				case NATURAL:
				case ON:
				case LATERAL:
				case WINDOW:
				case OVER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case UNBOUNDED:
				case PRECEDING:
				case FOLLOWING:
				case CURRENT:
				case FIRST:
				case AFTER:
				case LAST:
				case ROW:
				case WITH:
				case VALUES:
				case CREATE:
				case TABLE:
				case VIEW:
				case REPLACE:
				case INSERT:
				case DELETE:
				case INTO:
				case DESCRIBE:
				case EXPLAIN:
				case FORMAT:
				case LOGICAL:
				case CODEGEN:
				case COST:
				case CAST:
				case SHOW:
				case TABLES:
				case COLUMNS:
				case COLUMN:
				case USE:
				case PARTITIONS:
				case FUNCTIONS:
				case DROP:
				case UNION:
				case EXCEPT:
				case SETMINUS:
				case INTERSECT:
				case TO:
				case TABLESAMPLE:
				case STRATIFY:
				case ALTER:
				case RENAME:
				case ARRAY:
				case MAP:
				case STRUCT:
				case COMMENT:
				case SET:
				case RESET:
				case DATA:
				case START:
				case TRANSACTION:
				case COMMIT:
				case ROLLBACK:
				case MACRO:
				case IGNORE:
				case IF:
				case DIV:
				case PERCENTLIT:
				case BUCKET:
				case OUT:
				case OF:
				case SORT:
				case CLUSTER:
				case DISTRIBUTE:
				case OVERWRITE:
				case TRANSFORM:
				case REDUCE:
				case USING:
				case SERDE:
				case SERDEPROPERTIES:
				case RECORDREADER:
				case RECORDWRITER:
				case DELIMITED:
				case FIELDS:
				case TERMINATED:
				case COLLECTION:
				case ITEMS:
				case KEYS:
				case ESCAPED:
				case LINES:
				case SEPARATED:
				case FUNCTION:
				case EXTENDED:
				case REFRESH:
				case CLEAR:
				case CACHE:
				case UNCACHE:
				case LAZY:
				case FORMATTED:
				case GLOBAL:
				case TEMPORARY:
				case OPTIONS:
				case UNSET:
				case TBLPROPERTIES:
				case DBPROPERTIES:
				case BUCKETS:
				case SKEWED:
				case STORED:
				case DIRECTORIES:
				case LOCATION:
				case EXCHANGE:
				case ARCHIVE:
				case UNARCHIVE:
				case FILEFORMAT:
				case TOUCH:
				case COMPACT:
				case CONCATENATE:
				case CHANGE:
				case CASCADE:
				case RESTRICT:
				case CLUSTERED:
				case SORTED:
				case PURGE:
				case INPUTFORMAT:
				case OUTPUTFORMAT:
				case DATABASE:
				case DATABASES:
				case DFS:
				case TRUNCATE:
				case ANALYZE:
				case COMPUTE:
				case LIST:
				case STATISTICS:
				case PARTITIONED:
				case EXTERNAL:
				case DEFINED:
				case REVOKE:
				case GRANT:
				case LOCK:
				case UNLOCK:
				case MSCK:
				case REPAIR:
				case RECOVER:
				case EXPORT:
				case IMPORT:
				case LOAD:
				case ROLE:
				case ROLES:
				case COMPACTIONS:
				case PRINCIPALS:
				case TRANSACTIONS:
				case INDEX:
				case INDEXES:
				case LOCKS:
				case OPTION:
				case ANTI:
				case LOCAL:
				case INPATH:
				case CURRENT_DATE:
				case CURRENT_TIMESTAMP:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
				case SQUARE_BRACKET_IDENTIFIER:
					{
					setState(1228);
					identifier();
					}
					break;
				case STRING:
					{
					setState(1229);
					match(STRING);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(1236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtesContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public List<NamedQueryContext> namedQuery() {
			return getRuleContexts(NamedQueryContext.class);
		}
		public NamedQueryContext namedQuery(int i) {
			return getRuleContext(NamedQueryContext.class,i);
		}
		public CtesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCtes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCtes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCtes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtesContext ctes() throws RecognitionException {
		CtesContext _localctx = new CtesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ctes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1237);
			match(WITH);
			setState(1238);
			namedQuery();
			setState(1243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1239);
				match(T__4);
				setState(1240);
				namedQuery();
				}
				}
				setState(1245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedQueryContext extends ParserRuleContext {
		public IdentifierContext name;
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public NamedQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNamedQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNamedQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNamedQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedQueryContext namedQuery() throws RecognitionException {
		NamedQueryContext _localctx = new NamedQueryContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_namedQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
			((NamedQueryContext)_localctx).name = identifier();
			setState(1248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1247);
				match(AS);
				}
			}

			setState(1250);
			match(T__1);
			setState(1251);
			query();
			setState(1252);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableProviderContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(SqlScriptParser.USING, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableProviderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProvider; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTableProvider(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTableProvider(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTableProvider(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableProviderContext tableProvider() throws RecognitionException {
		TableProviderContext _localctx = new TableProviderContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_tableProvider);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1254);
			match(USING);
			setState(1255);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyListContext extends ParserRuleContext {
		public List<TablePropertyContext> tableProperty() {
			return getRuleContexts(TablePropertyContext.class);
		}
		public TablePropertyContext tableProperty(int i) {
			return getRuleContext(TablePropertyContext.class,i);
		}
		public TablePropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTablePropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTablePropertyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTablePropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyListContext tablePropertyList() throws RecognitionException {
		TablePropertyListContext _localctx = new TablePropertyListContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tablePropertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1257);
			match(T__1);
			setState(1258);
			tableProperty();
			setState(1263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1259);
				match(T__4);
				setState(1260);
				tableProperty();
				}
				}
				setState(1265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1266);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyContext extends ParserRuleContext {
		public TablePropertyKeyContext key;
		public TablePropertyValueContext value;
		public TablePropertyKeyContext tablePropertyKey() {
			return getRuleContext(TablePropertyKeyContext.class,0);
		}
		public TablePropertyValueContext tablePropertyValue() {
			return getRuleContext(TablePropertyValueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlScriptParser.EQ, 0); }
		public TablePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTableProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTableProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTableProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyContext tableProperty() throws RecognitionException {
		TablePropertyContext _localctx = new TablePropertyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_tableProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1268);
			((TablePropertyContext)_localctx).key = tablePropertyKey();
			setState(1273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || _la==EQ || ((((_la - 243)) & ~0x3f) == 0 && ((1L << (_la - 243)) & ((1L << (STRING - 243)) | (1L << (INTEGER_VALUE - 243)) | (1L << (DECIMAL_VALUE - 243)))) != 0)) {
				{
				setState(1270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(1269);
					match(EQ);
					}
				}

				setState(1272);
				((TablePropertyContext)_localctx).value = tablePropertyValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyKeyContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TablePropertyKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTablePropertyKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTablePropertyKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTablePropertyKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyKeyContext tablePropertyKey() throws RecognitionException {
		TablePropertyKeyContext _localctx = new TablePropertyKeyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_tablePropertyKey);
		int _la;
		try {
			setState(1284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case JOIN:
			case CROSS:
			case OUTER:
			case INNER:
			case LEFT:
			case SEMI:
			case RIGHT:
			case FULL:
			case NATURAL:
			case ON:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case UNION:
			case EXCEPT:
			case SETMINUS:
			case INTERSECT:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case ANTI:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
			case SQUARE_BRACKET_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1275);
				identifier();
				setState(1280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(1276);
					match(T__7);
					setState(1277);
					identifier();
					}
					}
					setState(1282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1283);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlScriptParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlScriptParser.DECIMAL_VALUE, 0); }
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TablePropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTablePropertyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTablePropertyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTablePropertyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyValueContext tablePropertyValue() throws RecognitionException {
		TablePropertyValueContext _localctx = new TablePropertyValueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_tablePropertyValue);
		try {
			setState(1290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1286);
				match(INTEGER_VALUE);
				}
				break;
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1287);
				match(DECIMAL_VALUE);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1288);
				booleanValue();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(1289);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantListContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public ConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitConstantList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1292);
			match(T__1);
			setState(1293);
			constant();
			setState(1298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1294);
				match(T__4);
				setState(1295);
				constant();
				}
				}
				setState(1300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1301);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedConstantListContext extends ParserRuleContext {
		public List<ConstantListContext> constantList() {
			return getRuleContexts(ConstantListContext.class);
		}
		public ConstantListContext constantList(int i) {
			return getRuleContext(ConstantListContext.class,i);
		}
		public NestedConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedConstantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNestedConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNestedConstantList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNestedConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedConstantListContext nestedConstantList() throws RecognitionException {
		NestedConstantListContext _localctx = new NestedConstantListContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_nestedConstantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1303);
			match(T__1);
			setState(1304);
			constantList();
			setState(1309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1305);
				match(T__4);
				setState(1306);
				constantList();
				}
				}
				setState(1311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1312);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateFileFormatContext extends ParserRuleContext {
		public TerminalNode STORED() { return getToken(SqlScriptParser.STORED, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public FileFormatContext fileFormat() {
			return getRuleContext(FileFormatContext.class,0);
		}
		public TerminalNode BY() { return getToken(SqlScriptParser.BY, 0); }
		public StorageHandlerContext storageHandler() {
			return getRuleContext(StorageHandlerContext.class,0);
		}
		public CreateFileFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createFileFormat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCreateFileFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCreateFileFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCreateFileFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateFileFormatContext createFileFormat() throws RecognitionException {
		CreateFileFormatContext _localctx = new CreateFileFormatContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_createFileFormat);
		try {
			setState(1320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1314);
				match(STORED);
				setState(1315);
				match(AS);
				setState(1316);
				fileFormat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1317);
				match(STORED);
				setState(1318);
				match(BY);
				setState(1319);
				storageHandler();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileFormatContext extends ParserRuleContext {
		public FileFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileFormat; }
	 
		public FileFormatContext() { }
		public void copyFrom(FileFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableFileFormatContext extends FileFormatContext {
		public Token inFmt;
		public Token outFmt;
		public TerminalNode INPUTFORMAT() { return getToken(SqlScriptParser.INPUTFORMAT, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(SqlScriptParser.OUTPUTFORMAT, 0); }
		public List<TerminalNode> STRING() { return getTokens(SqlScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlScriptParser.STRING, i);
		}
		public TableFileFormatContext(FileFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTableFileFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTableFileFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTableFileFormat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GenericFileFormatContext extends FileFormatContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GenericFileFormatContext(FileFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterGenericFileFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitGenericFileFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitGenericFileFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileFormatContext fileFormat() throws RecognitionException {
		FileFormatContext _localctx = new FileFormatContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_fileFormat);
		try {
			setState(1327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
			case 1:
				_localctx = new TableFileFormatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1322);
				match(INPUTFORMAT);
				setState(1323);
				((TableFileFormatContext)_localctx).inFmt = match(STRING);
				setState(1324);
				match(OUTPUTFORMAT);
				setState(1325);
				((TableFileFormatContext)_localctx).outFmt = match(STRING);
				}
				break;
			case 2:
				_localctx = new GenericFileFormatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1326);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageHandlerContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlScriptParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public StorageHandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageHandler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterStorageHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitStorageHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitStorageHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StorageHandlerContext storageHandler() throws RecognitionException {
		StorageHandlerContext _localctx = new StorageHandlerContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_storageHandler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1329);
			match(STRING);
			setState(1333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				{
				setState(1330);
				match(WITH);
				setState(1331);
				match(SERDEPROPERTIES);
				setState(1332);
				tablePropertyList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_resource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1335);
			identifier();
			setState(1336);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryNoWithContext extends ParserRuleContext {
		public QueryNoWithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryNoWith; }
	 
		public QueryNoWithContext() { }
		public void copyFrom(QueryNoWithContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleInsertQueryContext extends QueryNoWithContext {
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public QueryOrganizationContext queryOrganization() {
			return getRuleContext(QueryOrganizationContext.class,0);
		}
		public InsertIntoContext insertInto() {
			return getRuleContext(InsertIntoContext.class,0);
		}
		public SingleInsertQueryContext(QueryNoWithContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSingleInsertQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSingleInsertQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSingleInsertQuery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiInsertQueryContext extends QueryNoWithContext {
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public List<MultiInsertQueryBodyContext> multiInsertQueryBody() {
			return getRuleContexts(MultiInsertQueryBodyContext.class);
		}
		public MultiInsertQueryBodyContext multiInsertQueryBody(int i) {
			return getRuleContext(MultiInsertQueryBodyContext.class,i);
		}
		public MultiInsertQueryContext(QueryNoWithContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterMultiInsertQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitMultiInsertQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitMultiInsertQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryNoWithContext queryNoWith() throws RecognitionException {
		QueryNoWithContext _localctx = new QueryNoWithContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_queryNoWith);
		int _la;
		try {
			int _alt;
			setState(1350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				_localctx = new SingleInsertQueryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSERT) {
					{
					setState(1338);
					insertInto();
					}
				}

				setState(1341);
				queryTerm(0);
				setState(1342);
				queryOrganization();
				}
				break;
			case 2:
				_localctx = new MultiInsertQueryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1344);
				fromClause();
				setState(1346); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1345);
						multiInsertQueryBody();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1348); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryOrganizationContext extends ParserRuleContext {
		public SortItemContext sortItem;
		public List<SortItemContext> order = new ArrayList<SortItemContext>();
		public ExpressionContext expression;
		public List<ExpressionContext> clusterBy = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> distributeBy = new ArrayList<ExpressionContext>();
		public List<SortItemContext> sort = new ArrayList<SortItemContext>();
		public ExpressionContext limit;
		public TerminalNode ORDER() { return getToken(SqlScriptParser.ORDER, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlScriptParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlScriptParser.BY, i);
		}
		public TerminalNode CLUSTER() { return getToken(SqlScriptParser.CLUSTER, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(SqlScriptParser.DISTRIBUTE, 0); }
		public TerminalNode SORT() { return getToken(SqlScriptParser.SORT, 0); }
		public WindowsContext windows() {
			return getRuleContext(WindowsContext.class,0);
		}
		public TerminalNode LIMIT() { return getToken(SqlScriptParser.LIMIT, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public QueryOrganizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryOrganization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQueryOrganization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQueryOrganization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQueryOrganization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryOrganizationContext queryOrganization() throws RecognitionException {
		QueryOrganizationContext _localctx = new QueryOrganizationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_queryOrganization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				{
				setState(1352);
				match(ORDER);
				setState(1353);
				match(BY);
				setState(1354);
				((QueryOrganizationContext)_localctx).sortItem = sortItem();
				((QueryOrganizationContext)_localctx).order.add(((QueryOrganizationContext)_localctx).sortItem);
				setState(1359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1355);
					match(T__4);
					setState(1356);
					((QueryOrganizationContext)_localctx).sortItem = sortItem();
					((QueryOrganizationContext)_localctx).order.add(((QueryOrganizationContext)_localctx).sortItem);
					}
					}
					setState(1361);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(1374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				{
				setState(1364);
				match(CLUSTER);
				setState(1365);
				match(BY);
				setState(1366);
				((QueryOrganizationContext)_localctx).expression = expression();
				((QueryOrganizationContext)_localctx).clusterBy.add(((QueryOrganizationContext)_localctx).expression);
				setState(1371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1367);
					match(T__4);
					setState(1368);
					((QueryOrganizationContext)_localctx).expression = expression();
					((QueryOrganizationContext)_localctx).clusterBy.add(((QueryOrganizationContext)_localctx).expression);
					}
					}
					setState(1373);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(1386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				{
				setState(1376);
				match(DISTRIBUTE);
				setState(1377);
				match(BY);
				setState(1378);
				((QueryOrganizationContext)_localctx).expression = expression();
				((QueryOrganizationContext)_localctx).distributeBy.add(((QueryOrganizationContext)_localctx).expression);
				setState(1383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1379);
					match(T__4);
					setState(1380);
					((QueryOrganizationContext)_localctx).expression = expression();
					((QueryOrganizationContext)_localctx).distributeBy.add(((QueryOrganizationContext)_localctx).expression);
					}
					}
					setState(1385);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(1398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
			case 1:
				{
				setState(1388);
				match(SORT);
				setState(1389);
				match(BY);
				setState(1390);
				((QueryOrganizationContext)_localctx).sortItem = sortItem();
				((QueryOrganizationContext)_localctx).sort.add(((QueryOrganizationContext)_localctx).sortItem);
				setState(1395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1391);
					match(T__4);
					setState(1392);
					((QueryOrganizationContext)_localctx).sortItem = sortItem();
					((QueryOrganizationContext)_localctx).sort.add(((QueryOrganizationContext)_localctx).sortItem);
					}
					}
					setState(1397);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(1401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				{
				setState(1400);
				windows();
				}
				break;
			}
			setState(1405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				{
				setState(1403);
				match(LIMIT);
				setState(1404);
				((QueryOrganizationContext)_localctx).limit = expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiInsertQueryBodyContext extends ParserRuleContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryOrganizationContext queryOrganization() {
			return getRuleContext(QueryOrganizationContext.class,0);
		}
		public InsertIntoContext insertInto() {
			return getRuleContext(InsertIntoContext.class,0);
		}
		public MultiInsertQueryBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiInsertQueryBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterMultiInsertQueryBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitMultiInsertQueryBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitMultiInsertQueryBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiInsertQueryBodyContext multiInsertQueryBody() throws RecognitionException {
		MultiInsertQueryBodyContext _localctx = new MultiInsertQueryBodyContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_multiInsertQueryBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INSERT) {
				{
				setState(1407);
				insertInto();
				}
			}

			setState(1410);
			querySpecification();
			setState(1411);
			queryOrganization();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryTermContext extends ParserRuleContext {
		public QueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryTerm; }
	 
		public QueryTermContext() { }
		public void copyFrom(QueryTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QueryTermDefaultContext extends QueryTermContext {
		public QueryPrimaryContext queryPrimary() {
			return getRuleContext(QueryPrimaryContext.class,0);
		}
		public QueryTermDefaultContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQueryTermDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQueryTermDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQueryTermDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetOperationContext extends QueryTermContext {
		public QueryTermContext left;
		public Token operator;
		public QueryTermContext right;
		public List<QueryTermContext> queryTerm() {
			return getRuleContexts(QueryTermContext.class);
		}
		public QueryTermContext queryTerm(int i) {
			return getRuleContext(QueryTermContext.class,i);
		}
		public TerminalNode INTERSECT() { return getToken(SqlScriptParser.INTERSECT, 0); }
		public TerminalNode UNION() { return getToken(SqlScriptParser.UNION, 0); }
		public TerminalNode EXCEPT() { return getToken(SqlScriptParser.EXCEPT, 0); }
		public TerminalNode SETMINUS() { return getToken(SqlScriptParser.SETMINUS, 0); }
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public SetOperationContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSetOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSetOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSetOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryTermContext queryTerm() throws RecognitionException {
		return queryTerm(0);
	}

	private QueryTermContext queryTerm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryTermContext _localctx = new QueryTermContext(_ctx, _parentState);
		QueryTermContext _prevctx = _localctx;
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_queryTerm, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QueryTermDefaultContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(1414);
			queryPrimary();
			}
			_ctx.stop = _input.LT(-1);
			setState(1424);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SetOperationContext(new QueryTermContext(_parentctx, _parentState));
					((SetOperationContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_queryTerm);
					setState(1416);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1417);
					((SetOperationContext)_localctx).operator = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (UNION - 103)) | (1L << (EXCEPT - 103)) | (1L << (SETMINUS - 103)) | (1L << (INTERSECT - 103)))) != 0)) ) {
						((SetOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1419);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL || _la==DISTINCT) {
						{
						setState(1418);
						setQuantifier();
						}
					}

					setState(1421);
					((SetOperationContext)_localctx).right = queryTerm(2);
					}
					} 
				}
				setState(1426);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QueryPrimaryContext extends ParserRuleContext {
		public QueryPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryPrimary; }
	 
		public QueryPrimaryContext() { }
		public void copyFrom(QueryPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryContext extends QueryPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public SubqueryContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QueryPrimaryDefaultContext extends QueryPrimaryContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryPrimaryDefaultContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQueryPrimaryDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQueryPrimaryDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQueryPrimaryDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineTableDefault1Context extends QueryPrimaryContext {
		public InlineTableContext inlineTable() {
			return getRuleContext(InlineTableContext.class,0);
		}
		public InlineTableDefault1Context(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterInlineTableDefault1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitInlineTableDefault1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitInlineTableDefault1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableContext extends QueryPrimaryContext {
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryPrimaryContext queryPrimary() throws RecognitionException {
		QueryPrimaryContext _localctx = new QueryPrimaryContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_queryPrimary);
		try {
			setState(1435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case MAP:
			case REDUCE:
				_localctx = new QueryPrimaryDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1427);
				querySpecification();
				}
				break;
			case TABLE:
				_localctx = new TableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1428);
				match(TABLE);
				setState(1429);
				tableIdentifier();
				}
				break;
			case VALUES:
				_localctx = new InlineTableDefault1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1430);
				inlineTable();
				}
				break;
			case T__1:
				_localctx = new SubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1431);
				match(T__1);
				setState(1432);
				queryNoWith();
				setState(1433);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortItemContext extends ParserRuleContext {
		public Token ordering;
		public Token nullOrder;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(SqlScriptParser.NULLS, 0); }
		public TerminalNode ASC() { return getToken(SqlScriptParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlScriptParser.DESC, 0); }
		public TerminalNode LAST() { return getToken(SqlScriptParser.LAST, 0); }
		public TerminalNode FIRST() { return getToken(SqlScriptParser.FIRST, 0); }
		public SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSortItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSortItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSortItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortItemContext sortItem() throws RecognitionException {
		SortItemContext _localctx = new SortItemContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_sortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1437);
			expression();
			setState(1439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				{
				setState(1438);
				((SortItemContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((SortItemContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(1443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
			case 1:
				{
				setState(1441);
				match(NULLS);
				setState(1442);
				((SortItemContext)_localctx).nullOrder = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FIRST || _la==LAST) ) {
					((SortItemContext)_localctx).nullOrder = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public Token kind;
		public RowFormatContext inRowFormat;
		public Token recordWriter;
		public Token script;
		public RowFormatContext outRowFormat;
		public Token recordReader;
		public BooleanExpressionContext where;
		public HintContext hint;
		public List<HintContext> hints = new ArrayList<HintContext>();
		public BooleanExpressionContext having;
		public TerminalNode USING() { return getToken(SqlScriptParser.USING, 0); }
		public List<TerminalNode> STRING() { return getTokens(SqlScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlScriptParser.STRING, i);
		}
		public TerminalNode RECORDWRITER() { return getToken(SqlScriptParser.RECORDWRITER, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public TerminalNode RECORDREADER() { return getToken(SqlScriptParser.RECORDREADER, 0); }
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SqlScriptParser.WHERE, 0); }
		public TerminalNode SELECT() { return getToken(SqlScriptParser.SELECT, 0); }
		public NamedExpressionSeqContext namedExpressionSeq() {
			return getRuleContext(NamedExpressionSeqContext.class,0);
		}
		public List<RowFormatContext> rowFormat() {
			return getRuleContexts(RowFormatContext.class);
		}
		public RowFormatContext rowFormat(int i) {
			return getRuleContext(RowFormatContext.class,i);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode TRANSFORM() { return getToken(SqlScriptParser.TRANSFORM, 0); }
		public TerminalNode MAP() { return getToken(SqlScriptParser.MAP, 0); }
		public TerminalNode REDUCE() { return getToken(SqlScriptParser.REDUCE, 0); }
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public List<LateralViewContext> lateralView() {
			return getRuleContexts(LateralViewContext.class);
		}
		public LateralViewContext lateralView(int i) {
			return getRuleContext(LateralViewContext.class,i);
		}
		public AggregationContext aggregation() {
			return getRuleContext(AggregationContext.class,0);
		}
		public TerminalNode HAVING() { return getToken(SqlScriptParser.HAVING, 0); }
		public WindowsContext windows() {
			return getRuleContext(WindowsContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public List<HintContext> hint() {
			return getRuleContexts(HintContext.class);
		}
		public HintContext hint(int i) {
			return getRuleContext(HintContext.class,i);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQuerySpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQuerySpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_querySpecification);
		int _la;
		try {
			int _alt;
			setState(1538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(1455);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
					{
					setState(1445);
					match(SELECT);
					setState(1446);
					((QuerySpecificationContext)_localctx).kind = match(TRANSFORM);
					setState(1447);
					match(T__1);
					setState(1448);
					namedExpressionSeq();
					setState(1449);
					match(T__2);
					}
					break;
				case MAP:
					{
					setState(1451);
					((QuerySpecificationContext)_localctx).kind = match(MAP);
					setState(1452);
					namedExpressionSeq();
					}
					break;
				case REDUCE:
					{
					setState(1453);
					((QuerySpecificationContext)_localctx).kind = match(REDUCE);
					setState(1454);
					namedExpressionSeq();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(1457);
					((QuerySpecificationContext)_localctx).inRowFormat = rowFormat();
					}
				}

				setState(1462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RECORDWRITER) {
					{
					setState(1460);
					match(RECORDWRITER);
					setState(1461);
					((QuerySpecificationContext)_localctx).recordWriter = match(STRING);
					}
				}

				setState(1464);
				match(USING);
				setState(1465);
				((QuerySpecificationContext)_localctx).script = match(STRING);
				setState(1478);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
				case 1:
					{
					setState(1466);
					match(AS);
					setState(1476);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
					case 1:
						{
						setState(1467);
						identifierSeq();
						}
						break;
					case 2:
						{
						setState(1468);
						colTypeList();
						}
						break;
					case 3:
						{
						{
						setState(1469);
						match(T__1);
						setState(1472);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
						case 1:
							{
							setState(1470);
							identifierSeq();
							}
							break;
						case 2:
							{
							setState(1471);
							colTypeList();
							}
							break;
						}
						setState(1474);
						match(T__2);
						}
						}
						break;
					}
					}
					break;
				}
				setState(1481);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1480);
					((QuerySpecificationContext)_localctx).outRowFormat = rowFormat();
					}
					break;
				}
				setState(1485);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
				case 1:
					{
					setState(1483);
					match(RECORDREADER);
					setState(1484);
					((QuerySpecificationContext)_localctx).recordReader = match(STRING);
					}
					break;
				}
				setState(1488);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
				case 1:
					{
					setState(1487);
					fromClause();
					}
					break;
				}
				setState(1492);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
				case 1:
					{
					setState(1490);
					match(WHERE);
					setState(1491);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1516);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
					{
					setState(1494);
					((QuerySpecificationContext)_localctx).kind = match(SELECT);
					setState(1498);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(1495);
						((QuerySpecificationContext)_localctx).hint = hint();
						((QuerySpecificationContext)_localctx).hints.add(((QuerySpecificationContext)_localctx).hint);
						}
						}
						setState(1500);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1502);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
					case 1:
						{
						setState(1501);
						setQuantifier();
						}
						break;
					}
					setState(1504);
					namedExpressionSeq();
					setState(1506);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
					case 1:
						{
						setState(1505);
						fromClause();
						}
						break;
					}
					}
					break;
				case FROM:
					{
					setState(1508);
					fromClause();
					setState(1514);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
					case 1:
						{
						setState(1509);
						((QuerySpecificationContext)_localctx).kind = match(SELECT);
						setState(1511);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
						case 1:
							{
							setState(1510);
							setQuantifier();
							}
							break;
						}
						setState(1513);
						namedExpressionSeq();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1518);
						lateralView();
						}
						} 
					}
					setState(1523);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
				}
				setState(1526);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
				case 1:
					{
					setState(1524);
					match(WHERE);
					setState(1525);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(1529);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
				case 1:
					{
					setState(1528);
					aggregation();
					}
					break;
				}
				setState(1533);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
				case 1:
					{
					setState(1531);
					match(HAVING);
					setState(1532);
					((QuerySpecificationContext)_localctx).having = booleanExpression(0);
					}
					break;
				}
				setState(1536);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
				case 1:
					{
					setState(1535);
					windows();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HintContext extends ParserRuleContext {
		public HintStatementContext hintStatement;
		public List<HintStatementContext> hintStatements = new ArrayList<HintStatementContext>();
		public List<HintStatementContext> hintStatement() {
			return getRuleContexts(HintStatementContext.class);
		}
		public HintStatementContext hintStatement(int i) {
			return getRuleContext(HintStatementContext.class,i);
		}
		public HintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterHint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitHint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitHint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HintContext hint() throws RecognitionException {
		HintContext _localctx = new HintContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1540);
			match(T__8);
			setState(1541);
			((HintContext)_localctx).hintStatement = hintStatement();
			((HintContext)_localctx).hintStatements.add(((HintContext)_localctx).hintStatement);
			setState(1548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (DIV - 139)) | (1L << (PERCENTLIT - 139)) | (1L << (BUCKET - 139)) | (1L << (OUT - 139)) | (1L << (OF - 139)) | (1L << (SORT - 139)) | (1L << (CLUSTER - 139)) | (1L << (DISTRIBUTE - 139)) | (1L << (OVERWRITE - 139)) | (1L << (TRANSFORM - 139)) | (1L << (REDUCE - 139)) | (1L << (USING - 139)) | (1L << (SERDE - 139)) | (1L << (SERDEPROPERTIES - 139)) | (1L << (RECORDREADER - 139)) | (1L << (RECORDWRITER - 139)) | (1L << (DELIMITED - 139)) | (1L << (FIELDS - 139)) | (1L << (TERMINATED - 139)) | (1L << (COLLECTION - 139)) | (1L << (ITEMS - 139)) | (1L << (KEYS - 139)) | (1L << (ESCAPED - 139)) | (1L << (LINES - 139)) | (1L << (SEPARATED - 139)) | (1L << (FUNCTION - 139)) | (1L << (EXTENDED - 139)) | (1L << (REFRESH - 139)) | (1L << (CLEAR - 139)) | (1L << (CACHE - 139)) | (1L << (UNCACHE - 139)) | (1L << (LAZY - 139)) | (1L << (FORMATTED - 139)) | (1L << (GLOBAL - 139)) | (1L << (TEMPORARY - 139)) | (1L << (OPTIONS - 139)) | (1L << (UNSET - 139)) | (1L << (TBLPROPERTIES - 139)) | (1L << (DBPROPERTIES - 139)) | (1L << (BUCKETS - 139)) | (1L << (SKEWED - 139)) | (1L << (STORED - 139)) | (1L << (DIRECTORIES - 139)) | (1L << (LOCATION - 139)) | (1L << (EXCHANGE - 139)) | (1L << (ARCHIVE - 139)) | (1L << (UNARCHIVE - 139)) | (1L << (FILEFORMAT - 139)) | (1L << (TOUCH - 139)) | (1L << (COMPACT - 139)) | (1L << (CONCATENATE - 139)) | (1L << (CHANGE - 139)) | (1L << (CASCADE - 139)) | (1L << (RESTRICT - 139)) | (1L << (CLUSTERED - 139)) | (1L << (SORTED - 139)) | (1L << (PURGE - 139)) | (1L << (INPUTFORMAT - 139)) | (1L << (OUTPUTFORMAT - 139)))) != 0) || ((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (DATABASE - 203)) | (1L << (DATABASES - 203)) | (1L << (DFS - 203)) | (1L << (TRUNCATE - 203)) | (1L << (ANALYZE - 203)) | (1L << (COMPUTE - 203)) | (1L << (LIST - 203)) | (1L << (STATISTICS - 203)) | (1L << (PARTITIONED - 203)) | (1L << (EXTERNAL - 203)) | (1L << (DEFINED - 203)) | (1L << (REVOKE - 203)) | (1L << (GRANT - 203)) | (1L << (LOCK - 203)) | (1L << (UNLOCK - 203)) | (1L << (MSCK - 203)) | (1L << (REPAIR - 203)) | (1L << (RECOVER - 203)) | (1L << (EXPORT - 203)) | (1L << (IMPORT - 203)) | (1L << (LOAD - 203)) | (1L << (ROLE - 203)) | (1L << (ROLES - 203)) | (1L << (COMPACTIONS - 203)) | (1L << (PRINCIPALS - 203)) | (1L << (TRANSACTIONS - 203)) | (1L << (INDEX - 203)) | (1L << (INDEXES - 203)) | (1L << (LOCKS - 203)) | (1L << (OPTION - 203)) | (1L << (ANTI - 203)) | (1L << (LOCAL - 203)) | (1L << (INPATH - 203)) | (1L << (CURRENT_DATE - 203)) | (1L << (CURRENT_TIMESTAMP - 203)) | (1L << (IDENTIFIER - 203)) | (1L << (BACKQUOTED_IDENTIFIER - 203)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 203)))) != 0)) {
				{
				{
				setState(1543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(1542);
					match(T__4);
					}
				}

				setState(1545);
				((HintContext)_localctx).hintStatement = hintStatement();
				((HintContext)_localctx).hintStatements.add(((HintContext)_localctx).hintStatement);
				}
				}
				setState(1550);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1551);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HintStatementContext extends ParserRuleContext {
		public IdentifierContext hintName;
		public PrimaryExpressionContext primaryExpression;
		public List<PrimaryExpressionContext> parameters = new ArrayList<PrimaryExpressionContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public HintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hintStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterHintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitHintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitHintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HintStatementContext hintStatement() throws RecognitionException {
		HintStatementContext _localctx = new HintStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_hintStatement);
		int _la;
		try {
			setState(1566);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1553);
				((HintStatementContext)_localctx).hintName = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1554);
				((HintStatementContext)_localctx).hintName = identifier();
				setState(1555);
				match(T__1);
				setState(1556);
				((HintStatementContext)_localctx).primaryExpression = primaryExpression(0);
				((HintStatementContext)_localctx).parameters.add(((HintStatementContext)_localctx).primaryExpression);
				setState(1561);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1557);
					match(T__4);
					setState(1558);
					((HintStatementContext)_localctx).primaryExpression = primaryExpression(0);
					((HintStatementContext)_localctx).parameters.add(((HintStatementContext)_localctx).primaryExpression);
					}
					}
					setState(1563);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1564);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(SqlScriptParser.FROM, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<LateralViewContext> lateralView() {
			return getRuleContexts(LateralViewContext.class);
		}
		public LateralViewContext lateralView(int i) {
			return getRuleContext(LateralViewContext.class,i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitFromClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_fromClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1568);
			match(FROM);
			setState(1569);
			relation();
			setState(1574);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1570);
					match(T__4);
					setState(1571);
					relation();
					}
					} 
				}
				setState(1576);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			}
			setState(1580);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1577);
					lateralView();
					}
					} 
				}
				setState(1582);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,202,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregationContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> groupingExpressions = new ArrayList<ExpressionContext>();
		public Token kind;
		public TerminalNode GROUP() { return getToken(SqlScriptParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SqlScriptParser.BY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public TerminalNode SETS() { return getToken(SqlScriptParser.SETS, 0); }
		public List<GroupingSetContext> groupingSet() {
			return getRuleContexts(GroupingSetContext.class);
		}
		public GroupingSetContext groupingSet(int i) {
			return getRuleContext(GroupingSetContext.class,i);
		}
		public TerminalNode ROLLUP() { return getToken(SqlScriptParser.ROLLUP, 0); }
		public TerminalNode CUBE() { return getToken(SqlScriptParser.CUBE, 0); }
		public TerminalNode GROUPING() { return getToken(SqlScriptParser.GROUPING, 0); }
		public AggregationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterAggregation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitAggregation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitAggregation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregationContext aggregation() throws RecognitionException {
		AggregationContext _localctx = new AggregationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_aggregation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1583);
			match(GROUP);
			setState(1584);
			match(BY);
			setState(1585);
			((AggregationContext)_localctx).expression = expression();
			((AggregationContext)_localctx).groupingExpressions.add(((AggregationContext)_localctx).expression);
			setState(1590);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1586);
					match(T__4);
					setState(1587);
					((AggregationContext)_localctx).expression = expression();
					((AggregationContext)_localctx).groupingExpressions.add(((AggregationContext)_localctx).expression);
					}
					} 
				}
				setState(1592);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
			}
			setState(1610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
			case 1:
				{
				setState(1593);
				match(WITH);
				setState(1594);
				((AggregationContext)_localctx).kind = match(ROLLUP);
				}
				break;
			case 2:
				{
				setState(1595);
				match(WITH);
				setState(1596);
				((AggregationContext)_localctx).kind = match(CUBE);
				}
				break;
			case 3:
				{
				setState(1597);
				((AggregationContext)_localctx).kind = match(GROUPING);
				setState(1598);
				match(SETS);
				setState(1599);
				match(T__1);
				setState(1600);
				groupingSet();
				setState(1605);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1601);
					match(T__4);
					setState(1602);
					groupingSet();
					}
					}
					setState(1607);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1608);
				match(T__2);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingSetContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GroupingSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterGroupingSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitGroupingSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitGroupingSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingSetContext groupingSet() throws RecognitionException {
		GroupingSetContext _localctx = new GroupingSetContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_groupingSet);
		int _la;
		try {
			setState(1625);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1612);
				match(T__1);
				setState(1621);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PLUS - 134)) | (1L << (MINUS - 134)) | (1L << (ASTERISK - 134)) | (1L << (DIV - 134)) | (1L << (TILDE - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (CLUSTERED - 198)) | (1L << (SORTED - 198)) | (1L << (PURGE - 198)) | (1L << (INPUTFORMAT - 198)) | (1L << (OUTPUTFORMAT - 198)) | (1L << (DATABASE - 198)) | (1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (STRING - 198)) | (1L << (BIGINT_LITERAL - 198)) | (1L << (SMALLINT_LITERAL - 198)) | (1L << (TINYINT_LITERAL - 198)) | (1L << (INTEGER_VALUE - 198)) | (1L << (DECIMAL_VALUE - 198)) | (1L << (DOUBLE_LITERAL - 198)) | (1L << (BIGDECIMAL_LITERAL - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 198)))) != 0)) {
					{
					setState(1613);
					expression();
					setState(1618);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(1614);
						match(T__4);
						setState(1615);
						expression();
						}
						}
						setState(1620);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1623);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1624);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LateralViewContext extends ParserRuleContext {
		public IdentifierContext tblName;
		public IdentifierContext identifier;
		public List<IdentifierContext> colName = new ArrayList<IdentifierContext>();
		public TerminalNode LATERAL() { return getToken(SqlScriptParser.LATERAL, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OUTER() { return getToken(SqlScriptParser.OUTER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public LateralViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lateralView; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterLateralView(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitLateralView(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitLateralView(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LateralViewContext lateralView() throws RecognitionException {
		LateralViewContext _localctx = new LateralViewContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_lateralView);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1627);
			match(LATERAL);
			setState(1628);
			match(VIEW);
			setState(1630);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
			case 1:
				{
				setState(1629);
				match(OUTER);
				}
				break;
			}
			setState(1632);
			qualifiedName();
			setState(1633);
			match(T__1);
			setState(1642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PLUS - 134)) | (1L << (MINUS - 134)) | (1L << (ASTERISK - 134)) | (1L << (DIV - 134)) | (1L << (TILDE - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (CLUSTERED - 198)) | (1L << (SORTED - 198)) | (1L << (PURGE - 198)) | (1L << (INPUTFORMAT - 198)) | (1L << (OUTPUTFORMAT - 198)) | (1L << (DATABASE - 198)) | (1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (STRING - 198)) | (1L << (BIGINT_LITERAL - 198)) | (1L << (SMALLINT_LITERAL - 198)) | (1L << (TINYINT_LITERAL - 198)) | (1L << (INTEGER_VALUE - 198)) | (1L << (DECIMAL_VALUE - 198)) | (1L << (DOUBLE_LITERAL - 198)) | (1L << (BIGDECIMAL_LITERAL - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 198)))) != 0)) {
				{
				setState(1634);
				expression();
				setState(1639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1635);
					match(T__4);
					setState(1636);
					expression();
					}
					}
					setState(1641);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1644);
			match(T__2);
			setState(1645);
			((LateralViewContext)_localctx).tblName = identifier();
			setState(1657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
			case 1:
				{
				setState(1647);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
				case 1:
					{
					setState(1646);
					match(AS);
					}
					break;
				}
				setState(1649);
				((LateralViewContext)_localctx).identifier = identifier();
				((LateralViewContext)_localctx).colName.add(((LateralViewContext)_localctx).identifier);
				setState(1654);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,213,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1650);
						match(T__4);
						setState(1651);
						((LateralViewContext)_localctx).identifier = identifier();
						((LateralViewContext)_localctx).colName.add(((LateralViewContext)_localctx).identifier);
						}
						} 
					}
					setState(1656);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,213,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SqlScriptParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SqlScriptParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1659);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public List<JoinRelationContext> joinRelation() {
			return getRuleContexts(JoinRelationContext.class);
		}
		public JoinRelationContext joinRelation(int i) {
			return getRuleContext(JoinRelationContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_relation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1661);
			relationPrimary();
			setState(1665);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1662);
					joinRelation();
					}
					} 
				}
				setState(1667);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinRelationContext extends ParserRuleContext {
		public RelationPrimaryContext right;
		public TerminalNode JOIN() { return getToken(SqlScriptParser.JOIN, 0); }
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public JoinCriteriaContext joinCriteria() {
			return getRuleContext(JoinCriteriaContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SqlScriptParser.NATURAL, 0); }
		public JoinRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterJoinRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitJoinRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitJoinRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinRelationContext joinRelation() throws RecognitionException {
		JoinRelationContext _localctx = new JoinRelationContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_joinRelation);
		try {
			setState(1679);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JOIN:
			case CROSS:
			case INNER:
			case LEFT:
			case RIGHT:
			case FULL:
			case ANTI:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1668);
				joinType();
				}
				setState(1669);
				match(JOIN);
				setState(1670);
				((JoinRelationContext)_localctx).right = relationPrimary();
				setState(1672);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
				case 1:
					{
					setState(1671);
					joinCriteria();
					}
					break;
				}
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1674);
				match(NATURAL);
				setState(1675);
				joinType();
				setState(1676);
				match(JOIN);
				setState(1677);
				((JoinRelationContext)_localctx).right = relationPrimary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SqlScriptParser.INNER, 0); }
		public TerminalNode CROSS() { return getToken(SqlScriptParser.CROSS, 0); }
		public TerminalNode LEFT() { return getToken(SqlScriptParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(SqlScriptParser.OUTER, 0); }
		public TerminalNode SEMI() { return getToken(SqlScriptParser.SEMI, 0); }
		public TerminalNode RIGHT() { return getToken(SqlScriptParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SqlScriptParser.FULL, 0); }
		public TerminalNode ANTI() { return getToken(SqlScriptParser.ANTI, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_joinType);
		int _la;
		try {
			setState(1703);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1682);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INNER) {
					{
					setState(1681);
					match(INNER);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1684);
				match(CROSS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1685);
				match(LEFT);
				setState(1687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1686);
					match(OUTER);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1689);
				match(LEFT);
				setState(1690);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1691);
				match(RIGHT);
				setState(1693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1692);
					match(OUTER);
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1695);
				match(FULL);
				setState(1697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1696);
					match(OUTER);
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT) {
					{
					setState(1699);
					match(LEFT);
					}
				}

				setState(1702);
				match(ANTI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinCriteriaContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlScriptParser.ON, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SqlScriptParser.USING, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public JoinCriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCriteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterJoinCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitJoinCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitJoinCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinCriteriaContext joinCriteria() throws RecognitionException {
		JoinCriteriaContext _localctx = new JoinCriteriaContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_joinCriteria);
		int _la;
		try {
			setState(1719);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1705);
				match(ON);
				setState(1706);
				booleanExpression(0);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1707);
				match(USING);
				setState(1708);
				match(T__1);
				setState(1709);
				identifier();
				setState(1714);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1710);
					match(T__4);
					setState(1711);
					identifier();
					}
					}
					setState(1716);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1717);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampleContext extends ParserRuleContext {
		public Token percentage;
		public Token sampleType;
		public Token numerator;
		public Token denominator;
		public TerminalNode TABLESAMPLE() { return getToken(SqlScriptParser.TABLESAMPLE, 0); }
		public TerminalNode BYTELENGTH_LITERAL() { return getToken(SqlScriptParser.BYTELENGTH_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OUT() { return getToken(SqlScriptParser.OUT, 0); }
		public TerminalNode OF() { return getToken(SqlScriptParser.OF, 0); }
		public TerminalNode PERCENTLIT() { return getToken(SqlScriptParser.PERCENTLIT, 0); }
		public TerminalNode ROWS() { return getToken(SqlScriptParser.ROWS, 0); }
		public TerminalNode BUCKET() { return getToken(SqlScriptParser.BUCKET, 0); }
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(SqlScriptParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(SqlScriptParser.INTEGER_VALUE, i);
		}
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlScriptParser.DECIMAL_VALUE, 0); }
		public TerminalNode ON() { return getToken(SqlScriptParser.ON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public SampleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sample; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSample(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSample(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSample(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampleContext sample() throws RecognitionException {
		SampleContext _localctx = new SampleContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_sample);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1721);
			match(TABLESAMPLE);
			setState(1722);
			match(T__1);
			setState(1744);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
			case 1:
				{
				{
				setState(1723);
				((SampleContext)_localctx).percentage = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INTEGER_VALUE || _la==DECIMAL_VALUE) ) {
					((SampleContext)_localctx).percentage = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1724);
				((SampleContext)_localctx).sampleType = match(PERCENTLIT);
				}
				}
				break;
			case 2:
				{
				{
				setState(1725);
				expression();
				setState(1726);
				((SampleContext)_localctx).sampleType = match(ROWS);
				}
				}
				break;
			case 3:
				{
				setState(1728);
				((SampleContext)_localctx).sampleType = match(BYTELENGTH_LITERAL);
				}
				break;
			case 4:
				{
				{
				setState(1729);
				((SampleContext)_localctx).sampleType = match(BUCKET);
				setState(1730);
				((SampleContext)_localctx).numerator = match(INTEGER_VALUE);
				setState(1731);
				match(OUT);
				setState(1732);
				match(OF);
				setState(1733);
				((SampleContext)_localctx).denominator = match(INTEGER_VALUE);
				setState(1742);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1734);
					match(ON);
					setState(1740);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
					case 1:
						{
						setState(1735);
						identifier();
						}
						break;
					case 2:
						{
						setState(1736);
						qualifiedName();
						setState(1737);
						match(T__1);
						setState(1738);
						match(T__2);
						}
						break;
					}
					}
				}

				}
				}
				break;
			}
			setState(1746);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_identifierList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1748);
			match(T__1);
			setState(1749);
			identifierSeq();
			setState(1750);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierSeqContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IdentifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIdentifierSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIdentifierSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIdentifierSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierSeqContext identifierSeq() throws RecognitionException {
		IdentifierSeqContext _localctx = new IdentifierSeqContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_identifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1752);
			identifier();
			setState(1757);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,229,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1753);
					match(T__4);
					setState(1754);
					identifier();
					}
					} 
				}
				setState(1759);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,229,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderedIdentifierListContext extends ParserRuleContext {
		public List<OrderedIdentifierContext> orderedIdentifier() {
			return getRuleContexts(OrderedIdentifierContext.class);
		}
		public OrderedIdentifierContext orderedIdentifier(int i) {
			return getRuleContext(OrderedIdentifierContext.class,i);
		}
		public OrderedIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderedIdentifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterOrderedIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitOrderedIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitOrderedIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderedIdentifierListContext orderedIdentifierList() throws RecognitionException {
		OrderedIdentifierListContext _localctx = new OrderedIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_orderedIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1760);
			match(T__1);
			setState(1761);
			orderedIdentifier();
			setState(1766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1762);
				match(T__4);
				setState(1763);
				orderedIdentifier();
				}
				}
				setState(1768);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1769);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderedIdentifierContext extends ParserRuleContext {
		public Token ordering;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASC() { return getToken(SqlScriptParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlScriptParser.DESC, 0); }
		public OrderedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterOrderedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitOrderedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitOrderedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderedIdentifierContext orderedIdentifier() throws RecognitionException {
		OrderedIdentifierContext _localctx = new OrderedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_orderedIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1771);
			identifier();
			setState(1773);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1772);
				((OrderedIdentifierContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((OrderedIdentifierContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierCommentListContext extends ParserRuleContext {
		public List<IdentifierCommentContext> identifierComment() {
			return getRuleContexts(IdentifierCommentContext.class);
		}
		public IdentifierCommentContext identifierComment(int i) {
			return getRuleContext(IdentifierCommentContext.class,i);
		}
		public IdentifierCommentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierCommentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIdentifierCommentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIdentifierCommentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIdentifierCommentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierCommentListContext identifierCommentList() throws RecognitionException {
		IdentifierCommentListContext _localctx = new IdentifierCommentListContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_identifierCommentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1775);
			match(T__1);
			setState(1776);
			identifierComment();
			setState(1781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1777);
				match(T__4);
				setState(1778);
				identifierComment();
				}
				}
				setState(1783);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1784);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierCommentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public IdentifierCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIdentifierComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIdentifierComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIdentifierComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierCommentContext identifierComment() throws RecognitionException {
		IdentifierCommentContext _localctx = new IdentifierCommentContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_identifierComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1786);
			identifier();
			setState(1789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(1787);
				match(COMMENT);
				setState(1788);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationPrimaryContext extends ParserRuleContext {
		public RelationPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationPrimary; }
	 
		public RelationPrimaryContext() { }
		public void copyFrom(RelationPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableValuedFunctionContext extends RelationPrimaryContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TableValuedFunctionContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTableValuedFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTableValuedFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTableValuedFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineTableDefault2Context extends RelationPrimaryContext {
		public InlineTableContext inlineTable() {
			return getRuleContext(InlineTableContext.class,0);
		}
		public InlineTableDefault2Context(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterInlineTableDefault2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitInlineTableDefault2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitInlineTableDefault2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AliasedRelationContext extends RelationPrimaryContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public AliasedRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterAliasedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitAliasedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitAliasedRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AliasedQueryContext extends RelationPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public AliasedQueryContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterAliasedQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitAliasedQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitAliasedQuery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableNameContext extends RelationPrimaryContext {
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public TableNameContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationPrimaryContext relationPrimary() throws RecognitionException {
		RelationPrimaryContext _localctx = new RelationPrimaryContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_relationPrimary);
		int _la;
		try {
			setState(1840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				_localctx = new TableNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1791);
				tableIdentifier();
				setState(1793);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
				case 1:
					{
					setState(1792);
					sample();
					}
					break;
				}
				setState(1799);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
				case 1:
					{
					setState(1796);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
					case 1:
						{
						setState(1795);
						match(AS);
						}
						break;
					}
					setState(1798);
					strictIdentifier();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new AliasedQueryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1801);
				match(T__1);
				setState(1802);
				queryNoWith();
				setState(1803);
				match(T__2);
				setState(1805);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
				case 1:
					{
					setState(1804);
					sample();
					}
					break;
				}
				setState(1811);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
				case 1:
					{
					setState(1808);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
					case 1:
						{
						setState(1807);
						match(AS);
						}
						break;
					}
					setState(1810);
					strictIdentifier();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new AliasedRelationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1813);
				match(T__1);
				setState(1814);
				relation();
				setState(1815);
				match(T__2);
				setState(1817);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
				case 1:
					{
					setState(1816);
					sample();
					}
					break;
				}
				setState(1823);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
				case 1:
					{
					setState(1820);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
					case 1:
						{
						setState(1819);
						match(AS);
						}
						break;
					}
					setState(1822);
					strictIdentifier();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new InlineTableDefault2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1825);
				inlineTable();
				}
				break;
			case 5:
				_localctx = new TableValuedFunctionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1826);
				identifier();
				setState(1827);
				match(T__1);
				setState(1836);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PLUS - 134)) | (1L << (MINUS - 134)) | (1L << (ASTERISK - 134)) | (1L << (DIV - 134)) | (1L << (TILDE - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (CLUSTERED - 198)) | (1L << (SORTED - 198)) | (1L << (PURGE - 198)) | (1L << (INPUTFORMAT - 198)) | (1L << (OUTPUTFORMAT - 198)) | (1L << (DATABASE - 198)) | (1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (STRING - 198)) | (1L << (BIGINT_LITERAL - 198)) | (1L << (SMALLINT_LITERAL - 198)) | (1L << (TINYINT_LITERAL - 198)) | (1L << (INTEGER_VALUE - 198)) | (1L << (DECIMAL_VALUE - 198)) | (1L << (DOUBLE_LITERAL - 198)) | (1L << (BIGDECIMAL_LITERAL - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 198)))) != 0)) {
					{
					setState(1828);
					expression();
					setState(1833);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(1829);
						match(T__4);
						setState(1830);
						expression();
						}
						}
						setState(1835);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1838);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineTableContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(SqlScriptParser.VALUES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public InlineTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterInlineTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitInlineTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitInlineTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTableContext inlineTable() throws RecognitionException {
		InlineTableContext _localctx = new InlineTableContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_inlineTable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1842);
			match(VALUES);
			setState(1843);
			expression();
			setState(1848);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1844);
					match(T__4);
					setState(1845);
					expression();
					}
					} 
				}
				setState(1850);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
			}
			setState(1858);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
			case 1:
				{
				setState(1852);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,247,_ctx) ) {
				case 1:
					{
					setState(1851);
					match(AS);
					}
					break;
				}
				setState(1854);
				identifier();
				setState(1856);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
				case 1:
					{
					setState(1855);
					identifierList();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowFormatContext extends ParserRuleContext {
		public RowFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowFormat; }
	 
		public RowFormatContext() { }
		public void copyFrom(RowFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RowFormatSerdeContext extends RowFormatContext {
		public Token name;
		public TablePropertyListContext props;
		public TerminalNode ROW() { return getToken(SqlScriptParser.ROW, 0); }
		public TerminalNode FORMAT() { return getToken(SqlScriptParser.FORMAT, 0); }
		public TerminalNode SERDE() { return getToken(SqlScriptParser.SERDE, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlScriptParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public RowFormatSerdeContext(RowFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRowFormatSerde(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRowFormatSerde(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRowFormatSerde(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowFormatDelimitedContext extends RowFormatContext {
		public Token fieldsTerminatedBy;
		public Token escapedBy;
		public Token collectionItemsTerminatedBy;
		public Token keysTerminatedBy;
		public Token linesSeparatedBy;
		public Token nullDefinedAs;
		public TerminalNode ROW() { return getToken(SqlScriptParser.ROW, 0); }
		public TerminalNode FORMAT() { return getToken(SqlScriptParser.FORMAT, 0); }
		public TerminalNode DELIMITED() { return getToken(SqlScriptParser.DELIMITED, 0); }
		public TerminalNode FIELDS() { return getToken(SqlScriptParser.FIELDS, 0); }
		public List<TerminalNode> TERMINATED() { return getTokens(SqlScriptParser.TERMINATED); }
		public TerminalNode TERMINATED(int i) {
			return getToken(SqlScriptParser.TERMINATED, i);
		}
		public List<TerminalNode> BY() { return getTokens(SqlScriptParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlScriptParser.BY, i);
		}
		public TerminalNode COLLECTION() { return getToken(SqlScriptParser.COLLECTION, 0); }
		public TerminalNode ITEMS() { return getToken(SqlScriptParser.ITEMS, 0); }
		public TerminalNode MAP() { return getToken(SqlScriptParser.MAP, 0); }
		public TerminalNode KEYS() { return getToken(SqlScriptParser.KEYS, 0); }
		public TerminalNode LINES() { return getToken(SqlScriptParser.LINES, 0); }
		public TerminalNode NULL() { return getToken(SqlScriptParser.NULL, 0); }
		public TerminalNode DEFINED() { return getToken(SqlScriptParser.DEFINED, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public List<TerminalNode> STRING() { return getTokens(SqlScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlScriptParser.STRING, i);
		}
		public TerminalNode ESCAPED() { return getToken(SqlScriptParser.ESCAPED, 0); }
		public RowFormatDelimitedContext(RowFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRowFormatDelimited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRowFormatDelimited(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRowFormatDelimited(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowFormatContext rowFormat() throws RecognitionException {
		RowFormatContext _localctx = new RowFormatContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_rowFormat);
		try {
			setState(1909);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,257,_ctx) ) {
			case 1:
				_localctx = new RowFormatSerdeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1860);
				match(ROW);
				setState(1861);
				match(FORMAT);
				setState(1862);
				match(SERDE);
				setState(1863);
				((RowFormatSerdeContext)_localctx).name = match(STRING);
				setState(1867);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
				case 1:
					{
					setState(1864);
					match(WITH);
					setState(1865);
					match(SERDEPROPERTIES);
					setState(1866);
					((RowFormatSerdeContext)_localctx).props = tablePropertyList();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new RowFormatDelimitedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1869);
				match(ROW);
				setState(1870);
				match(FORMAT);
				setState(1871);
				match(DELIMITED);
				setState(1881);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1872);
					match(FIELDS);
					setState(1873);
					match(TERMINATED);
					setState(1874);
					match(BY);
					setState(1875);
					((RowFormatDelimitedContext)_localctx).fieldsTerminatedBy = match(STRING);
					setState(1879);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
					case 1:
						{
						setState(1876);
						match(ESCAPED);
						setState(1877);
						match(BY);
						setState(1878);
						((RowFormatDelimitedContext)_localctx).escapedBy = match(STRING);
						}
						break;
					}
					}
					break;
				}
				setState(1888);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
				case 1:
					{
					setState(1883);
					match(COLLECTION);
					setState(1884);
					match(ITEMS);
					setState(1885);
					match(TERMINATED);
					setState(1886);
					match(BY);
					setState(1887);
					((RowFormatDelimitedContext)_localctx).collectionItemsTerminatedBy = match(STRING);
					}
					break;
				}
				setState(1895);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
				case 1:
					{
					setState(1890);
					match(MAP);
					setState(1891);
					match(KEYS);
					setState(1892);
					match(TERMINATED);
					setState(1893);
					match(BY);
					setState(1894);
					((RowFormatDelimitedContext)_localctx).keysTerminatedBy = match(STRING);
					}
					break;
				}
				setState(1901);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
				case 1:
					{
					setState(1897);
					match(LINES);
					setState(1898);
					match(TERMINATED);
					setState(1899);
					match(BY);
					setState(1900);
					((RowFormatDelimitedContext)_localctx).linesSeparatedBy = match(STRING);
					}
					break;
				}
				setState(1907);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
				case 1:
					{
					setState(1903);
					match(NULL);
					setState(1904);
					match(DEFINED);
					setState(1905);
					match(AS);
					setState(1906);
					((RowFormatDelimitedContext)_localctx).nullDefinedAs = match(STRING);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableIdentifierContext extends ParserRuleContext {
		public IdentifierContext db;
		public IdentifierContext table;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTableIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTableIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableIdentifierContext tableIdentifier() throws RecognitionException {
		TableIdentifierContext _localctx = new TableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_tableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1914);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				{
				setState(1911);
				((TableIdentifierContext)_localctx).db = identifier();
				setState(1912);
				match(T__7);
				}
				break;
			}
			setState(1916);
			((TableIdentifierContext)_localctx).table = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionIdentifierContext extends ParserRuleContext {
		public IdentifierContext db;
		public IdentifierContext function;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public FunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIdentifierContext functionIdentifier() throws RecognitionException {
		FunctionIdentifierContext _localctx = new FunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_functionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1921);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				{
				setState(1918);
				((FunctionIdentifierContext)_localctx).db = identifier();
				setState(1919);
				match(T__7);
				}
				break;
			}
			setState(1923);
			((FunctionIdentifierContext)_localctx).function = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public NamedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNamedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNamedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNamedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedExpressionContext namedExpression() throws RecognitionException {
		NamedExpressionContext _localctx = new NamedExpressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_namedExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1925);
			expression();
			setState(1933);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				{
				setState(1927);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
				case 1:
					{
					setState(1926);
					match(AS);
					}
					break;
				}
				setState(1931);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
				case FROM:
				case ADD:
				case AS:
				case ALL:
				case DISTINCT:
				case WHERE:
				case GROUP:
				case BY:
				case GROUPING:
				case SETS:
				case CUBE:
				case ROLLUP:
				case ORDER:
				case HAVING:
				case LIMIT:
				case AT:
				case OR:
				case AND:
				case IN:
				case NOT:
				case NO:
				case EXISTS:
				case BETWEEN:
				case LIKE:
				case RLIKE:
				case IS:
				case NULL:
				case TRUE:
				case FALSE:
				case NULLS:
				case ASC:
				case DESC:
				case FOR:
				case INTERVAL:
				case CASE:
				case WHEN:
				case THEN:
				case ELSE:
				case END:
				case JOIN:
				case CROSS:
				case OUTER:
				case INNER:
				case LEFT:
				case SEMI:
				case RIGHT:
				case FULL:
				case NATURAL:
				case ON:
				case LATERAL:
				case WINDOW:
				case OVER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case UNBOUNDED:
				case PRECEDING:
				case FOLLOWING:
				case CURRENT:
				case FIRST:
				case AFTER:
				case LAST:
				case ROW:
				case WITH:
				case VALUES:
				case CREATE:
				case TABLE:
				case VIEW:
				case REPLACE:
				case INSERT:
				case DELETE:
				case INTO:
				case DESCRIBE:
				case EXPLAIN:
				case FORMAT:
				case LOGICAL:
				case CODEGEN:
				case COST:
				case CAST:
				case SHOW:
				case TABLES:
				case COLUMNS:
				case COLUMN:
				case USE:
				case PARTITIONS:
				case FUNCTIONS:
				case DROP:
				case UNION:
				case EXCEPT:
				case SETMINUS:
				case INTERSECT:
				case TO:
				case TABLESAMPLE:
				case STRATIFY:
				case ALTER:
				case RENAME:
				case ARRAY:
				case MAP:
				case STRUCT:
				case COMMENT:
				case SET:
				case RESET:
				case DATA:
				case START:
				case TRANSACTION:
				case COMMIT:
				case ROLLBACK:
				case MACRO:
				case IGNORE:
				case IF:
				case DIV:
				case PERCENTLIT:
				case BUCKET:
				case OUT:
				case OF:
				case SORT:
				case CLUSTER:
				case DISTRIBUTE:
				case OVERWRITE:
				case TRANSFORM:
				case REDUCE:
				case USING:
				case SERDE:
				case SERDEPROPERTIES:
				case RECORDREADER:
				case RECORDWRITER:
				case DELIMITED:
				case FIELDS:
				case TERMINATED:
				case COLLECTION:
				case ITEMS:
				case KEYS:
				case ESCAPED:
				case LINES:
				case SEPARATED:
				case FUNCTION:
				case EXTENDED:
				case REFRESH:
				case CLEAR:
				case CACHE:
				case UNCACHE:
				case LAZY:
				case FORMATTED:
				case GLOBAL:
				case TEMPORARY:
				case OPTIONS:
				case UNSET:
				case TBLPROPERTIES:
				case DBPROPERTIES:
				case BUCKETS:
				case SKEWED:
				case STORED:
				case DIRECTORIES:
				case LOCATION:
				case EXCHANGE:
				case ARCHIVE:
				case UNARCHIVE:
				case FILEFORMAT:
				case TOUCH:
				case COMPACT:
				case CONCATENATE:
				case CHANGE:
				case CASCADE:
				case RESTRICT:
				case CLUSTERED:
				case SORTED:
				case PURGE:
				case INPUTFORMAT:
				case OUTPUTFORMAT:
				case DATABASE:
				case DATABASES:
				case DFS:
				case TRUNCATE:
				case ANALYZE:
				case COMPUTE:
				case LIST:
				case STATISTICS:
				case PARTITIONED:
				case EXTERNAL:
				case DEFINED:
				case REVOKE:
				case GRANT:
				case LOCK:
				case UNLOCK:
				case MSCK:
				case REPAIR:
				case RECOVER:
				case EXPORT:
				case IMPORT:
				case LOAD:
				case ROLE:
				case ROLES:
				case COMPACTIONS:
				case PRINCIPALS:
				case TRANSACTIONS:
				case INDEX:
				case INDEXES:
				case LOCKS:
				case OPTION:
				case ANTI:
				case LOCAL:
				case INPATH:
				case CURRENT_DATE:
				case CURRENT_TIMESTAMP:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
				case SQUARE_BRACKET_IDENTIFIER:
					{
					setState(1929);
					identifier();
					}
					break;
				case T__1:
					{
					setState(1930);
					identifierList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedExpressionSeqContext extends ParserRuleContext {
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public NamedExpressionSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedExpressionSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNamedExpressionSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNamedExpressionSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNamedExpressionSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedExpressionSeqContext namedExpressionSeq() throws RecognitionException {
		NamedExpressionSeqContext _localctx = new NamedExpressionSeqContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_namedExpressionSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1935);
			namedExpression();
			setState(1940);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1936);
					match(T__4);
					setState(1937);
					namedExpression();
					}
					} 
				}
				setState(1942);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1943);
			booleanExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
	 
		public BooleanExpressionContext() { }
		public void copyFrom(BooleanExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalNotContext extends BooleanExpressionContext {
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public LogicalNotContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterLogicalNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitLogicalNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitLogicalNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OptionalLogicalContext extends BooleanExpressionContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public OptionalLogicalContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterOptionalLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitOptionalLogical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitOptionalLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanDefaultContext extends BooleanExpressionContext {
		public PredicatedContext predicated() {
			return getRuleContext(PredicatedContext.class,0);
		}
		public BooleanDefaultContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterBooleanDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitBooleanDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitBooleanDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsContext extends BooleanExpressionContext {
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ExistsContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitExists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitExists(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalBinaryContext extends BooleanExpressionContext {
		public BooleanExpressionContext left;
		public Token operator;
		public BooleanExpressionContext right;
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SqlScriptParser.AND, 0); }
		public TerminalNode OR() { return getToken(SqlScriptParser.OR, 0); }
		public LogicalBinaryContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterLogicalBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitLogicalBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitLogicalBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 156;
		enterRecursionRule(_localctx, 156, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1958);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
			case 1:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1946);
				match(NOT);
				setState(1947);
				booleanExpression(6);
				}
				break;
			case 2:
				{
				_localctx = new ExistsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1948);
				match(EXISTS);
				setState(1949);
				match(T__1);
				setState(1950);
				query();
				setState(1951);
				match(T__2);
				}
				break;
			case 3:
				{
				_localctx = new OptionalLogicalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1953);
				match(T__10);
				setState(1954);
				booleanExpression(0);
				setState(1955);
				match(T__11);
				}
				break;
			case 4:
				{
				_localctx = new BooleanDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1957);
				predicated();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1968);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,266,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1966);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(1960);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1961);
						((LogicalBinaryContext)_localctx).operator = match(AND);
						setState(1962);
						((LogicalBinaryContext)_localctx).right = booleanExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(1963);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1964);
						((LogicalBinaryContext)_localctx).operator = match(OR);
						setState(1965);
						((LogicalBinaryContext)_localctx).right = booleanExpression(2);
						}
						break;
					}
					} 
				}
				setState(1970);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,266,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicatedContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPredicated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPredicated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPredicated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatedContext predicated() throws RecognitionException {
		PredicatedContext _localctx = new PredicatedContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_predicated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1971);
			valueExpression(0);
			setState(1973);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(1972);
				predicate();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public Token kind;
		public ValueExpressionContext lower;
		public ValueExpressionContext upper;
		public ValueExpressionContext pattern;
		public TerminalNode AND() { return getToken(SqlScriptParser.AND, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlScriptParser.BETWEEN, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IN() { return getToken(SqlScriptParser.IN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode RLIKE() { return getToken(SqlScriptParser.RLIKE, 0); }
		public TerminalNode LIKE() { return getToken(SqlScriptParser.LIKE, 0); }
		public TerminalNode IS() { return getToken(SqlScriptParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SqlScriptParser.NULL, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_predicate);
		int _la;
		try {
			setState(2016);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1976);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1975);
					match(NOT);
					}
				}

				setState(1978);
				((PredicateContext)_localctx).kind = match(BETWEEN);
				setState(1979);
				((PredicateContext)_localctx).lower = valueExpression(0);
				setState(1980);
				match(AND);
				setState(1981);
				((PredicateContext)_localctx).upper = valueExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1984);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1983);
					match(NOT);
					}
				}

				setState(1986);
				((PredicateContext)_localctx).kind = match(IN);
				setState(1987);
				match(T__1);
				setState(1988);
				expression();
				setState(1993);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1989);
					match(T__4);
					setState(1990);
					expression();
					}
					}
					setState(1995);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1996);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1999);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1998);
					match(NOT);
					}
				}

				setState(2001);
				((PredicateContext)_localctx).kind = match(IN);
				setState(2002);
				match(T__1);
				setState(2003);
				query();
				setState(2004);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(2006);
					match(NOT);
					}
				}

				setState(2009);
				((PredicateContext)_localctx).kind = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LIKE || _la==RLIKE) ) {
					((PredicateContext)_localctx).kind = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2010);
				((PredicateContext)_localctx).pattern = valueExpression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2011);
				match(IS);
				setState(2013);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(2012);
					match(NOT);
					}
				}

				setState(2015);
				((PredicateContext)_localctx).kind = match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
	 
		public ValueExpressionContext() { }
		public void copyFrom(ValueExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueExpressionDefaultContext extends ValueExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionDefaultContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterValueExpressionDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitValueExpressionDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitValueExpressionDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public ValueExpressionContext right;
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public ComparisonContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticBinaryContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public Token operator;
		public ValueExpressionContext right;
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(SqlScriptParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SqlScriptParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(SqlScriptParser.PERCENT, 0); }
		public TerminalNode DIV() { return getToken(SqlScriptParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(SqlScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public TerminalNode AMPERSAND() { return getToken(SqlScriptParser.AMPERSAND, 0); }
		public TerminalNode HAT() { return getToken(SqlScriptParser.HAT, 0); }
		public TerminalNode PIPE() { return getToken(SqlScriptParser.PIPE, 0); }
		public ArithmeticBinaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterArithmeticBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitArithmeticBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitArithmeticBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticUnaryContext extends ValueExpressionContext {
		public Token operator;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SqlScriptParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(SqlScriptParser.TILDE, 0); }
		public ArithmeticUnaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterArithmeticUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitArithmeticUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitArithmeticUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		return valueExpression(0);
	}

	private ValueExpressionContext valueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, _parentState);
		ValueExpressionContext _prevctx = _localctx;
		int _startState = 162;
		enterRecursionRule(_localctx, 162, RULE_valueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2022);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				{
				_localctx = new ValueExpressionDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(2019);
				primaryExpression(0);
				}
				break;
			case 2:
				{
				_localctx = new ArithmeticUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2020);
				((ArithmeticUnaryContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PLUS - 134)) | (1L << (MINUS - 134)) | (1L << (TILDE - 134)))) != 0)) ) {
					((ArithmeticUnaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2021);
				valueExpression(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2045);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,277,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2043);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,276,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(2024);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(2025);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 136)) & ~0x3f) == 0 && ((1L << (_la - 136)) & ((1L << (ASTERISK - 136)) | (1L << (SLASH - 136)) | (1L << (PERCENT - 136)) | (1L << (DIV - 136)))) != 0)) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(2026);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(7);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(2027);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(2028);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(2029);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(6);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(2030);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2031);
						((ArithmeticBinaryContext)_localctx).operator = match(AMPERSAND);
						setState(2032);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(5);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(2033);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2034);
						((ArithmeticBinaryContext)_localctx).operator = match(HAT);
						setState(2035);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(4);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(2036);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2037);
						((ArithmeticBinaryContext)_localctx).operator = match(PIPE);
						setState(2038);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(3);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonContext(new ValueExpressionContext(_parentctx, _parentState));
						((ComparisonContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(2039);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2040);
						comparisonOperator();
						setState(2041);
						((ComparisonContext)_localctx).right = valueExpression(2);
						}
						break;
					}
					} 
				}
				setState(2047);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,277,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructContext extends PrimaryExpressionContext {
		public NamedExpressionContext namedExpression;
		public List<NamedExpressionContext> argument = new ArrayList<NamedExpressionContext>();
		public TerminalNode STRUCT() { return getToken(SqlScriptParser.STRUCT, 0); }
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public StructContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DereferenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext base;
		public IdentifierContext fieldName;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DereferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDereference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDereference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDereference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleCaseContext extends PrimaryExpressionContext {
		public ExpressionContext value;
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(SqlScriptParser.CASE, 0); }
		public TerminalNode END() { return getToken(SqlScriptParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlScriptParser.ELSE, 0); }
		public SimpleCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSimpleCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSimpleCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSimpleCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnReferenceContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnReferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterColumnReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitColumnReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowConstructorContext extends PrimaryExpressionContext {
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public RowConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterRowConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitRowConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitRowConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LastContext extends PrimaryExpressionContext {
		public TerminalNode LAST() { return getToken(SqlScriptParser.LAST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IGNORE() { return getToken(SqlScriptParser.IGNORE, 0); }
		public TerminalNode NULLS() { return getToken(SqlScriptParser.NULLS, 0); }
		public LastContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitLast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitLast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StarContext extends PrimaryExpressionContext {
		public TerminalNode ASTERISK() { return getToken(SqlScriptParser.ASTERISK, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public StarContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitStar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext value;
		public ValueExpressionContext index;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public SubscriptContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimeFunctionCallContext extends PrimaryExpressionContext {
		public Token name;
		public TerminalNode CURRENT_DATE() { return getToken(SqlScriptParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SqlScriptParser.CURRENT_TIMESTAMP, 0); }
		public TimeFunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTimeFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTimeFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTimeFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubqueryExpressionContext extends PrimaryExpressionContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSubqueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSubqueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSubqueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastContext extends PrimaryExpressionContext {
		public TerminalNode CAST() { return getToken(SqlScriptParser.CAST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public CastContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantDefaultContext extends PrimaryExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantDefaultContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterConstantDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitConstantDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitConstantDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedExpressionContext extends PrimaryExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends PrimaryExpressionContext {
		public ExpressionContext expression;
		public List<ExpressionContext> argument = new ArrayList<ExpressionContext>();
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode OVER() { return getToken(SqlScriptParser.OVER, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public FunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SearchedCaseContext extends PrimaryExpressionContext {
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(SqlScriptParser.CASE, 0); }
		public TerminalNode END() { return getToken(SqlScriptParser.END, 0); }
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlScriptParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SearchedCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSearchedCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSearchedCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSearchedCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FirstContext extends PrimaryExpressionContext {
		public TerminalNode FIRST() { return getToken(SqlScriptParser.FIRST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IGNORE() { return getToken(SqlScriptParser.IGNORE, 0); }
		public TerminalNode NULLS() { return getToken(SqlScriptParser.NULLS, 0); }
		public FirstContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitFirst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitFirst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 164;
		enterRecursionRule(_localctx, 164, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
			case 1:
				{
				_localctx = new TimeFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(2049);
				((TimeFunctionCallContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CURRENT_DATE || _la==CURRENT_TIMESTAMP) ) {
					((TimeFunctionCallContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				_localctx = new SearchedCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2050);
				match(CASE);
				setState(2052); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2051);
					whenClause();
					}
					}
					setState(2054); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(2058);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(2056);
					match(ELSE);
					setState(2057);
					((SearchedCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(2060);
				match(END);
				}
				break;
			case 3:
				{
				_localctx = new SimpleCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2062);
				match(CASE);
				setState(2063);
				((SimpleCaseContext)_localctx).value = expression();
				setState(2065); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2064);
					whenClause();
					}
					}
					setState(2067); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(2071);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(2069);
					match(ELSE);
					setState(2070);
					((SimpleCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(2073);
				match(END);
				}
				break;
			case 4:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2075);
				match(CAST);
				setState(2076);
				match(T__1);
				setState(2077);
				expression();
				setState(2078);
				match(AS);
				setState(2079);
				dataType();
				setState(2080);
				match(T__2);
				}
				break;
			case 5:
				{
				_localctx = new StructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2082);
				match(STRUCT);
				setState(2083);
				match(T__1);
				setState(2092);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PLUS - 134)) | (1L << (MINUS - 134)) | (1L << (ASTERISK - 134)) | (1L << (DIV - 134)) | (1L << (TILDE - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (CLUSTERED - 198)) | (1L << (SORTED - 198)) | (1L << (PURGE - 198)) | (1L << (INPUTFORMAT - 198)) | (1L << (OUTPUTFORMAT - 198)) | (1L << (DATABASE - 198)) | (1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (STRING - 198)) | (1L << (BIGINT_LITERAL - 198)) | (1L << (SMALLINT_LITERAL - 198)) | (1L << (TINYINT_LITERAL - 198)) | (1L << (INTEGER_VALUE - 198)) | (1L << (DECIMAL_VALUE - 198)) | (1L << (DOUBLE_LITERAL - 198)) | (1L << (BIGDECIMAL_LITERAL - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 198)))) != 0)) {
					{
					setState(2084);
					((StructContext)_localctx).namedExpression = namedExpression();
					((StructContext)_localctx).argument.add(((StructContext)_localctx).namedExpression);
					setState(2089);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(2085);
						match(T__4);
						setState(2086);
						((StructContext)_localctx).namedExpression = namedExpression();
						((StructContext)_localctx).argument.add(((StructContext)_localctx).namedExpression);
						}
						}
						setState(2091);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2094);
				match(T__2);
				}
				break;
			case 6:
				{
				_localctx = new FirstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2095);
				match(FIRST);
				setState(2096);
				match(T__1);
				setState(2097);
				expression();
				setState(2100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE) {
					{
					setState(2098);
					match(IGNORE);
					setState(2099);
					match(NULLS);
					}
				}

				setState(2102);
				match(T__2);
				}
				break;
			case 7:
				{
				_localctx = new LastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2104);
				match(LAST);
				setState(2105);
				match(T__1);
				setState(2106);
				expression();
				setState(2109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE) {
					{
					setState(2107);
					match(IGNORE);
					setState(2108);
					match(NULLS);
					}
				}

				setState(2111);
				match(T__2);
				}
				break;
			case 8:
				{
				_localctx = new ConstantDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2113);
				constant();
				}
				break;
			case 9:
				{
				_localctx = new StarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2114);
				match(ASTERISK);
				}
				break;
			case 10:
				{
				_localctx = new StarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2115);
				qualifiedName();
				setState(2116);
				match(T__7);
				setState(2117);
				match(ASTERISK);
				}
				break;
			case 11:
				{
				_localctx = new RowConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2119);
				match(T__1);
				setState(2120);
				namedExpression();
				setState(2123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2121);
					match(T__4);
					setState(2122);
					namedExpression();
					}
					}
					setState(2125); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
				setState(2127);
				match(T__2);
				}
				break;
			case 12:
				{
				_localctx = new SubqueryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2129);
				match(T__1);
				setState(2130);
				query();
				setState(2131);
				match(T__2);
				}
				break;
			case 13:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2133);
				qualifiedName();
				setState(2134);
				match(T__1);
				setState(2146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PLUS - 134)) | (1L << (MINUS - 134)) | (1L << (ASTERISK - 134)) | (1L << (DIV - 134)) | (1L << (TILDE - 134)) | (1L << (PERCENTLIT - 134)) | (1L << (BUCKET - 134)) | (1L << (OUT - 134)) | (1L << (OF - 134)) | (1L << (SORT - 134)) | (1L << (CLUSTER - 134)) | (1L << (DISTRIBUTE - 134)) | (1L << (OVERWRITE - 134)) | (1L << (TRANSFORM - 134)) | (1L << (REDUCE - 134)) | (1L << (USING - 134)) | (1L << (SERDE - 134)) | (1L << (SERDEPROPERTIES - 134)) | (1L << (RECORDREADER - 134)) | (1L << (RECORDWRITER - 134)) | (1L << (DELIMITED - 134)) | (1L << (FIELDS - 134)) | (1L << (TERMINATED - 134)) | (1L << (COLLECTION - 134)) | (1L << (ITEMS - 134)) | (1L << (KEYS - 134)) | (1L << (ESCAPED - 134)) | (1L << (LINES - 134)) | (1L << (SEPARATED - 134)) | (1L << (FUNCTION - 134)) | (1L << (EXTENDED - 134)) | (1L << (REFRESH - 134)) | (1L << (CLEAR - 134)) | (1L << (CACHE - 134)) | (1L << (UNCACHE - 134)) | (1L << (LAZY - 134)) | (1L << (FORMATTED - 134)) | (1L << (GLOBAL - 134)) | (1L << (TEMPORARY - 134)) | (1L << (OPTIONS - 134)) | (1L << (UNSET - 134)) | (1L << (TBLPROPERTIES - 134)) | (1L << (DBPROPERTIES - 134)) | (1L << (BUCKETS - 134)) | (1L << (SKEWED - 134)) | (1L << (STORED - 134)) | (1L << (DIRECTORIES - 134)) | (1L << (LOCATION - 134)) | (1L << (EXCHANGE - 134)) | (1L << (ARCHIVE - 134)) | (1L << (UNARCHIVE - 134)) | (1L << (FILEFORMAT - 134)) | (1L << (TOUCH - 134)) | (1L << (COMPACT - 134)) | (1L << (CONCATENATE - 134)) | (1L << (CHANGE - 134)) | (1L << (CASCADE - 134)) | (1L << (RESTRICT - 134)))) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (CLUSTERED - 198)) | (1L << (SORTED - 198)) | (1L << (PURGE - 198)) | (1L << (INPUTFORMAT - 198)) | (1L << (OUTPUTFORMAT - 198)) | (1L << (DATABASE - 198)) | (1L << (DATABASES - 198)) | (1L << (DFS - 198)) | (1L << (TRUNCATE - 198)) | (1L << (ANALYZE - 198)) | (1L << (COMPUTE - 198)) | (1L << (LIST - 198)) | (1L << (STATISTICS - 198)) | (1L << (PARTITIONED - 198)) | (1L << (EXTERNAL - 198)) | (1L << (DEFINED - 198)) | (1L << (REVOKE - 198)) | (1L << (GRANT - 198)) | (1L << (LOCK - 198)) | (1L << (UNLOCK - 198)) | (1L << (MSCK - 198)) | (1L << (REPAIR - 198)) | (1L << (RECOVER - 198)) | (1L << (EXPORT - 198)) | (1L << (IMPORT - 198)) | (1L << (LOAD - 198)) | (1L << (ROLE - 198)) | (1L << (ROLES - 198)) | (1L << (COMPACTIONS - 198)) | (1L << (PRINCIPALS - 198)) | (1L << (TRANSACTIONS - 198)) | (1L << (INDEX - 198)) | (1L << (INDEXES - 198)) | (1L << (LOCKS - 198)) | (1L << (OPTION - 198)) | (1L << (ANTI - 198)) | (1L << (LOCAL - 198)) | (1L << (INPATH - 198)) | (1L << (CURRENT_DATE - 198)) | (1L << (CURRENT_TIMESTAMP - 198)) | (1L << (STRING - 198)) | (1L << (BIGINT_LITERAL - 198)) | (1L << (SMALLINT_LITERAL - 198)) | (1L << (TINYINT_LITERAL - 198)) | (1L << (INTEGER_VALUE - 198)) | (1L << (DECIMAL_VALUE - 198)) | (1L << (DOUBLE_LITERAL - 198)) | (1L << (BIGDECIMAL_LITERAL - 198)) | (1L << (IDENTIFIER - 198)) | (1L << (BACKQUOTED_IDENTIFIER - 198)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 198)))) != 0)) {
					{
					setState(2136);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
					case 1:
						{
						setState(2135);
						setQuantifier();
						}
						break;
					}
					setState(2138);
					((FunctionCallContext)_localctx).expression = expression();
					((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
					setState(2143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(2139);
						match(T__4);
						setState(2140);
						((FunctionCallContext)_localctx).expression = expression();
						((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
						}
						}
						setState(2145);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(2148);
				match(T__2);
				setState(2151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
				case 1:
					{
					setState(2149);
					match(OVER);
					setState(2150);
					windowSpec();
					}
					break;
				}
				}
				break;
			case 14:
				{
				_localctx = new ColumnReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2153);
				identifier();
				}
				break;
			case 15:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2154);
				match(T__1);
				setState(2155);
				expression();
				setState(2156);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2168);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
					case 1:
						{
						_localctx = new SubscriptContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((SubscriptContext)_localctx).value = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(2160);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2161);
						match(T__12);
						setState(2162);
						((SubscriptContext)_localctx).index = valueExpression(0);
						setState(2163);
						match(T__13);
						}
						break;
					case 2:
						{
						_localctx = new DereferenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((DereferenceContext)_localctx).base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(2165);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2166);
						match(T__7);
						setState(2167);
						((DereferenceContext)_localctx).fieldName = identifier();
						}
						break;
					}
					} 
				}
				setState(2172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullLiteralContext extends ConstantContext {
		public TerminalNode NULL() { return getToken(SqlScriptParser.NULL, 0); }
		public NullLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ConstantContext {
		public List<TerminalNode> STRING() { return getTokens(SqlScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SqlScriptParser.STRING, i);
		}
		public StringLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeConstructorContext extends ConstantContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public TypeConstructorContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTypeConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTypeConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntervalLiteralContext extends ConstantContext {
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public IntervalLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIntervalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIntervalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIntervalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericLiteralContext extends ConstantContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends ConstantContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_constant);
		try {
			int _alt;
			setState(2185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,295,_ctx) ) {
			case 1:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2173);
				match(NULL);
				}
				break;
			case 2:
				_localctx = new IntervalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2174);
				interval();
				}
				break;
			case 3:
				_localctx = new TypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2175);
				identifier();
				setState(2176);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new NumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2178);
				number();
				}
				break;
			case 5:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(2179);
				booleanValue();
				}
				break;
			case 6:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(2181); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2180);
						match(STRING);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2183); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,294,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SqlScriptParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SqlScriptParser.NEQ, 0); }
		public TerminalNode NEQJ() { return getToken(SqlScriptParser.NEQJ, 0); }
		public TerminalNode LT() { return getToken(SqlScriptParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SqlScriptParser.LTE, 0); }
		public TerminalNode GT() { return getToken(SqlScriptParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SqlScriptParser.GTE, 0); }
		public TerminalNode NSEQ() { return getToken(SqlScriptParser.NSEQ, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2187);
			_la = _input.LA(1);
			if ( !(((((_la - 126)) & ~0x3f) == 0 && ((1L << (_la - 126)) & ((1L << (EQ - 126)) | (1L << (NSEQ - 126)) | (1L << (NEQ - 126)) | (1L << (NEQJ - 126)) | (1L << (LT - 126)) | (1L << (LTE - 126)) | (1L << (GT - 126)) | (1L << (GTE - 126)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(SqlScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public TerminalNode ASTERISK() { return getToken(SqlScriptParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SqlScriptParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(SqlScriptParser.PERCENT, 0); }
		public TerminalNode DIV() { return getToken(SqlScriptParser.DIV, 0); }
		public TerminalNode TILDE() { return getToken(SqlScriptParser.TILDE, 0); }
		public TerminalNode AMPERSAND() { return getToken(SqlScriptParser.AMPERSAND, 0); }
		public TerminalNode PIPE() { return getToken(SqlScriptParser.PIPE, 0); }
		public TerminalNode HAT() { return getToken(SqlScriptParser.HAT, 0); }
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterArithmeticOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitArithmeticOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitArithmeticOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2189);
			_la = _input.LA(1);
			if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PLUS - 134)) | (1L << (MINUS - 134)) | (1L << (ASTERISK - 134)) | (1L << (SLASH - 134)) | (1L << (PERCENT - 134)) | (1L << (DIV - 134)) | (1L << (TILDE - 134)) | (1L << (AMPERSAND - 134)) | (1L << (PIPE - 134)) | (1L << (HAT - 134)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateOperatorContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(SqlScriptParser.OR, 0); }
		public TerminalNode AND() { return getToken(SqlScriptParser.AND, 0); }
		public TerminalNode IN() { return getToken(SqlScriptParser.IN, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public PredicateOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPredicateOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPredicateOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPredicateOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateOperatorContext predicateOperator() throws RecognitionException {
		PredicateOperatorContext _localctx = new PredicateOperatorContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_predicateOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2191);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SqlScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SqlScriptParser.FALSE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2193);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalContext extends ParserRuleContext {
		public TerminalNode INTERVAL() { return getToken(SqlScriptParser.INTERVAL, 0); }
		public List<IntervalFieldContext> intervalField() {
			return getRuleContexts(IntervalFieldContext.class);
		}
		public IntervalFieldContext intervalField(int i) {
			return getRuleContext(IntervalFieldContext.class,i);
		}
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_interval);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2195);
			match(INTERVAL);
			setState(2199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,296,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2196);
					intervalField();
					}
					} 
				}
				setState(2201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,296,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalFieldContext extends ParserRuleContext {
		public IntervalValueContext value;
		public IdentifierContext unit;
		public IdentifierContext to;
		public IntervalValueContext intervalValue() {
			return getRuleContext(IntervalValueContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TO() { return getToken(SqlScriptParser.TO, 0); }
		public IntervalFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIntervalField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIntervalField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIntervalField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalFieldContext intervalField() throws RecognitionException {
		IntervalFieldContext _localctx = new IntervalFieldContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_intervalField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2202);
			((IntervalFieldContext)_localctx).value = intervalValue();
			setState(2203);
			((IntervalFieldContext)_localctx).unit = identifier();
			setState(2206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				{
				setState(2204);
				match(TO);
				setState(2205);
				((IntervalFieldContext)_localctx).to = identifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlScriptParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlScriptParser.DECIMAL_VALUE, 0); }
		public TerminalNode PLUS() { return getToken(SqlScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public IntervalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIntervalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIntervalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIntervalValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalValueContext intervalValue() throws RecognitionException {
		IntervalValueContext _localctx = new IntervalValueContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_intervalValue);
		int _la;
		try {
			setState(2213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(2208);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(2211);
				_la = _input.LA(1);
				if ( !(_la==INTEGER_VALUE || _la==DECIMAL_VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2212);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColPositionContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(SqlScriptParser.FIRST, 0); }
		public TerminalNode AFTER() { return getToken(SqlScriptParser.AFTER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colPosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterColPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitColPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitColPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColPositionContext colPosition() throws RecognitionException {
		ColPositionContext _localctx = new ColPositionContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_colPosition);
		try {
			setState(2218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(2215);
				match(FIRST);
				}
				break;
			case AFTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(2216);
				match(AFTER);
				setState(2217);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexDataTypeContext extends DataTypeContext {
		public Token complex;
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public TerminalNode ARRAY() { return getToken(SqlScriptParser.ARRAY, 0); }
		public TerminalNode MAP() { return getToken(SqlScriptParser.MAP, 0); }
		public TerminalNode STRUCT() { return getToken(SqlScriptParser.STRUCT, 0); }
		public TerminalNode NEQ() { return getToken(SqlScriptParser.NEQ, 0); }
		public ComplexColTypeListContext complexColTypeList() {
			return getRuleContext(ComplexColTypeListContext.class,0);
		}
		public ComplexDataTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterComplexDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitComplexDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitComplexDataType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveDataTypeContext extends DataTypeContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(SqlScriptParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(SqlScriptParser.INTEGER_VALUE, i);
		}
		public PrimitiveDataTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterPrimitiveDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitPrimitiveDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitPrimitiveDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_dataType);
		int _la;
		try {
			setState(2254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
			case 1:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2220);
				((ComplexDataTypeContext)_localctx).complex = match(ARRAY);
				setState(2221);
				match(LT);
				setState(2222);
				dataType();
				setState(2223);
				match(GT);
				}
				break;
			case 2:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2225);
				((ComplexDataTypeContext)_localctx).complex = match(MAP);
				setState(2226);
				match(LT);
				setState(2227);
				dataType();
				setState(2228);
				match(T__4);
				setState(2229);
				dataType();
				setState(2230);
				match(GT);
				}
				break;
			case 3:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2232);
				((ComplexDataTypeContext)_localctx).complex = match(STRUCT);
				setState(2239);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(2233);
					match(LT);
					setState(2235);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << JOIN) | (1L << CROSS) | (1L << OUTER) | (1L << INNER) | (1L << LEFT) | (1L << SEMI) | (1L << RIGHT) | (1L << FULL) | (1L << NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)) | (1L << (TABLESAMPLE - 64)) | (1L << (STRATIFY - 64)) | (1L << (ALTER - 64)) | (1L << (RENAME - 64)) | (1L << (ARRAY - 64)) | (1L << (MAP - 64)) | (1L << (STRUCT - 64)) | (1L << (COMMENT - 64)) | (1L << (SET - 64)) | (1L << (RESET - 64)) | (1L << (DATA - 64)) | (1L << (START - 64)) | (1L << (TRANSACTION - 64)) | (1L << (COMMIT - 64)) | (1L << (ROLLBACK - 64)) | (1L << (MACRO - 64)) | (1L << (IGNORE - 64)) | (1L << (IF - 64)))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (DIV - 139)) | (1L << (PERCENTLIT - 139)) | (1L << (BUCKET - 139)) | (1L << (OUT - 139)) | (1L << (OF - 139)) | (1L << (SORT - 139)) | (1L << (CLUSTER - 139)) | (1L << (DISTRIBUTE - 139)) | (1L << (OVERWRITE - 139)) | (1L << (TRANSFORM - 139)) | (1L << (REDUCE - 139)) | (1L << (USING - 139)) | (1L << (SERDE - 139)) | (1L << (SERDEPROPERTIES - 139)) | (1L << (RECORDREADER - 139)) | (1L << (RECORDWRITER - 139)) | (1L << (DELIMITED - 139)) | (1L << (FIELDS - 139)) | (1L << (TERMINATED - 139)) | (1L << (COLLECTION - 139)) | (1L << (ITEMS - 139)) | (1L << (KEYS - 139)) | (1L << (ESCAPED - 139)) | (1L << (LINES - 139)) | (1L << (SEPARATED - 139)) | (1L << (FUNCTION - 139)) | (1L << (EXTENDED - 139)) | (1L << (REFRESH - 139)) | (1L << (CLEAR - 139)) | (1L << (CACHE - 139)) | (1L << (UNCACHE - 139)) | (1L << (LAZY - 139)) | (1L << (FORMATTED - 139)) | (1L << (GLOBAL - 139)) | (1L << (TEMPORARY - 139)) | (1L << (OPTIONS - 139)) | (1L << (UNSET - 139)) | (1L << (TBLPROPERTIES - 139)) | (1L << (DBPROPERTIES - 139)) | (1L << (BUCKETS - 139)) | (1L << (SKEWED - 139)) | (1L << (STORED - 139)) | (1L << (DIRECTORIES - 139)) | (1L << (LOCATION - 139)) | (1L << (EXCHANGE - 139)) | (1L << (ARCHIVE - 139)) | (1L << (UNARCHIVE - 139)) | (1L << (FILEFORMAT - 139)) | (1L << (TOUCH - 139)) | (1L << (COMPACT - 139)) | (1L << (CONCATENATE - 139)) | (1L << (CHANGE - 139)) | (1L << (CASCADE - 139)) | (1L << (RESTRICT - 139)) | (1L << (CLUSTERED - 139)) | (1L << (SORTED - 139)) | (1L << (PURGE - 139)) | (1L << (INPUTFORMAT - 139)) | (1L << (OUTPUTFORMAT - 139)))) != 0) || ((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (DATABASE - 203)) | (1L << (DATABASES - 203)) | (1L << (DFS - 203)) | (1L << (TRUNCATE - 203)) | (1L << (ANALYZE - 203)) | (1L << (COMPUTE - 203)) | (1L << (LIST - 203)) | (1L << (STATISTICS - 203)) | (1L << (PARTITIONED - 203)) | (1L << (EXTERNAL - 203)) | (1L << (DEFINED - 203)) | (1L << (REVOKE - 203)) | (1L << (GRANT - 203)) | (1L << (LOCK - 203)) | (1L << (UNLOCK - 203)) | (1L << (MSCK - 203)) | (1L << (REPAIR - 203)) | (1L << (RECOVER - 203)) | (1L << (EXPORT - 203)) | (1L << (IMPORT - 203)) | (1L << (LOAD - 203)) | (1L << (ROLE - 203)) | (1L << (ROLES - 203)) | (1L << (COMPACTIONS - 203)) | (1L << (PRINCIPALS - 203)) | (1L << (TRANSACTIONS - 203)) | (1L << (INDEX - 203)) | (1L << (INDEXES - 203)) | (1L << (LOCKS - 203)) | (1L << (OPTION - 203)) | (1L << (ANTI - 203)) | (1L << (LOCAL - 203)) | (1L << (INPATH - 203)) | (1L << (CURRENT_DATE - 203)) | (1L << (CURRENT_TIMESTAMP - 203)) | (1L << (IDENTIFIER - 203)) | (1L << (BACKQUOTED_IDENTIFIER - 203)) | (1L << (SQUARE_BRACKET_IDENTIFIER - 203)))) != 0)) {
						{
						setState(2234);
						complexColTypeList();
						}
					}

					setState(2237);
					match(GT);
					}
					break;
				case NEQ:
					{
					setState(2238);
					match(NEQ);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				_localctx = new PrimitiveDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2241);
				identifier();
				setState(2252);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
				case 1:
					{
					setState(2242);
					match(T__1);
					setState(2243);
					match(INTEGER_VALUE);
					setState(2248);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(2244);
						match(T__4);
						setState(2245);
						match(INTEGER_VALUE);
						}
						}
						setState(2250);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2251);
					match(T__2);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeListContext extends ParserRuleContext {
		public List<ColTypeContext> colType() {
			return getRuleContexts(ColTypeContext.class);
		}
		public ColTypeContext colType(int i) {
			return getRuleContext(ColTypeContext.class,i);
		}
		public ColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterColTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitColTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitColTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeListContext colTypeList() throws RecognitionException {
		ColTypeListContext _localctx = new ColTypeListContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_colTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2256);
			colType();
			setState(2261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,306,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2257);
					match(T__4);
					setState(2258);
					colType();
					}
					} 
				}
				setState(2263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,306,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public ColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterColType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitColType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitColType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeContext colType() throws RecognitionException {
		ColTypeContext _localctx = new ColTypeContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_colType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2264);
			identifier();
			setState(2265);
			dataType();
			setState(2268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
			case 1:
				{
				setState(2266);
				match(COMMENT);
				setState(2267);
				match(STRING);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexColTypeListContext extends ParserRuleContext {
		public List<ComplexColTypeContext> complexColType() {
			return getRuleContexts(ComplexColTypeContext.class);
		}
		public ComplexColTypeContext complexColType(int i) {
			return getRuleContext(ComplexColTypeContext.class,i);
		}
		public ComplexColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexColTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterComplexColTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitComplexColTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitComplexColTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexColTypeListContext complexColTypeList() throws RecognitionException {
		ComplexColTypeListContext _localctx = new ComplexColTypeListContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_complexColTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2270);
			complexColType();
			setState(2275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(2271);
				match(T__4);
				setState(2272);
				complexColType();
				}
				}
				setState(2277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexColTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(SqlScriptParser.STRING, 0); }
		public ComplexColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexColType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterComplexColType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitComplexColType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitComplexColType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexColTypeContext complexColType() throws RecognitionException {
		ComplexColTypeContext _localctx = new ComplexColTypeContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_complexColType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2278);
			identifier();
			setState(2279);
			match(T__6);
			setState(2280);
			dataType();
			setState(2283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(2281);
				match(COMMENT);
				setState(2282);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenClauseContext extends ParserRuleContext {
		public ExpressionContext condition;
		public ExpressionContext result;
		public TerminalNode WHEN() { return getToken(SqlScriptParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(SqlScriptParser.THEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterWhenClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitWhenClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitWhenClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenClauseContext whenClause() throws RecognitionException {
		WhenClauseContext _localctx = new WhenClauseContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_whenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2285);
			match(WHEN);
			setState(2286);
			((WhenClauseContext)_localctx).condition = expression();
			setState(2287);
			match(THEN);
			setState(2288);
			((WhenClauseContext)_localctx).result = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowsContext extends ParserRuleContext {
		public TerminalNode WINDOW() { return getToken(SqlScriptParser.WINDOW, 0); }
		public List<NamedWindowContext> namedWindow() {
			return getRuleContexts(NamedWindowContext.class);
		}
		public NamedWindowContext namedWindow(int i) {
			return getRuleContext(NamedWindowContext.class,i);
		}
		public WindowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterWindows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitWindows(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitWindows(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowsContext windows() throws RecognitionException {
		WindowsContext _localctx = new WindowsContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_windows);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2290);
			match(WINDOW);
			setState(2291);
			namedWindow();
			setState(2296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,310,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2292);
					match(T__4);
					setState(2293);
					namedWindow();
					}
					} 
				}
				setState(2298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,310,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedWindowContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public NamedWindowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedWindow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNamedWindow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNamedWindow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNamedWindow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedWindowContext namedWindow() throws RecognitionException {
		NamedWindowContext _localctx = new NamedWindowContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_namedWindow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2299);
			identifier();
			setState(2300);
			match(AS);
			setState(2301);
			windowSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowSpecContext extends ParserRuleContext {
		public WindowSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpec; }
	 
		public WindowSpecContext() { }
		public void copyFrom(WindowSpecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WindowRefContext extends WindowSpecContext {
		public IdentifierContext name;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public WindowRefContext(WindowSpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterWindowRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitWindowRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitWindowRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WindowDefContext extends WindowSpecContext {
		public ExpressionContext expression;
		public List<ExpressionContext> partition = new ArrayList<ExpressionContext>();
		public TerminalNode CLUSTER() { return getToken(SqlScriptParser.CLUSTER, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlScriptParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlScriptParser.BY, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WindowFrameContext windowFrame() {
			return getRuleContext(WindowFrameContext.class,0);
		}
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public TerminalNode PARTITION() { return getToken(SqlScriptParser.PARTITION, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(SqlScriptParser.DISTRIBUTE, 0); }
		public TerminalNode ORDER() { return getToken(SqlScriptParser.ORDER, 0); }
		public TerminalNode SORT() { return getToken(SqlScriptParser.SORT, 0); }
		public WindowDefContext(WindowSpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterWindowDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitWindowDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitWindowDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowSpecContext windowSpec() throws RecognitionException {
		WindowSpecContext _localctx = new WindowSpecContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_windowSpec);
		int _la;
		try {
			setState(2345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case JOIN:
			case CROSS:
			case OUTER:
			case INNER:
			case LEFT:
			case SEMI:
			case RIGHT:
			case FULL:
			case NATURAL:
			case ON:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case UNION:
			case EXCEPT:
			case SETMINUS:
			case INTERSECT:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case ANTI:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
			case SQUARE_BRACKET_IDENTIFIER:
				_localctx = new WindowRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2303);
				((WindowRefContext)_localctx).name = identifier();
				}
				break;
			case T__1:
				_localctx = new WindowDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2304);
				match(T__1);
				setState(2339);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLUSTER:
					{
					setState(2305);
					match(CLUSTER);
					setState(2306);
					match(BY);
					setState(2307);
					((WindowDefContext)_localctx).expression = expression();
					((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
					setState(2312);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(2308);
						match(T__4);
						setState(2309);
						((WindowDefContext)_localctx).expression = expression();
						((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
						}
						}
						setState(2314);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__2:
				case ORDER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case SORT:
				case DISTRIBUTE:
					{
					setState(2325);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PARTITION || _la==DISTRIBUTE) {
						{
						setState(2315);
						_la = _input.LA(1);
						if ( !(_la==PARTITION || _la==DISTRIBUTE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(2316);
						match(BY);
						setState(2317);
						((WindowDefContext)_localctx).expression = expression();
						((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
						setState(2322);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__4) {
							{
							{
							setState(2318);
							match(T__4);
							setState(2319);
							((WindowDefContext)_localctx).expression = expression();
							((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
							}
							}
							setState(2324);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(2337);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ORDER || _la==SORT) {
						{
						setState(2327);
						_la = _input.LA(1);
						if ( !(_la==ORDER || _la==SORT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(2328);
						match(BY);
						setState(2329);
						sortItem();
						setState(2334);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__4) {
							{
							{
							setState(2330);
							match(T__4);
							setState(2331);
							sortItem();
							}
							}
							setState(2336);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RANGE || _la==ROWS) {
					{
					setState(2341);
					windowFrame();
					}
				}

				setState(2344);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameContext extends ParserRuleContext {
		public Token frameType;
		public FrameBoundContext start;
		public FrameBoundContext end;
		public TerminalNode RANGE() { return getToken(SqlScriptParser.RANGE, 0); }
		public List<FrameBoundContext> frameBound() {
			return getRuleContexts(FrameBoundContext.class);
		}
		public FrameBoundContext frameBound(int i) {
			return getRuleContext(FrameBoundContext.class,i);
		}
		public TerminalNode ROWS() { return getToken(SqlScriptParser.ROWS, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlScriptParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SqlScriptParser.AND, 0); }
		public WindowFrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterWindowFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitWindowFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitWindowFrame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameContext windowFrame() throws RecognitionException {
		WindowFrameContext _localctx = new WindowFrameContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_windowFrame);
		try {
			setState(2363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2347);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(2348);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2349);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(2350);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2351);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(2352);
				match(BETWEEN);
				setState(2353);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(2354);
				match(AND);
				setState(2355);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2357);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(2358);
				match(BETWEEN);
				setState(2359);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(2360);
				match(AND);
				setState(2361);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FrameBoundContext extends ParserRuleContext {
		public Token boundType;
		public TerminalNode UNBOUNDED() { return getToken(SqlScriptParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlScriptParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlScriptParser.FOLLOWING, 0); }
		public TerminalNode ROW() { return getToken(SqlScriptParser.ROW, 0); }
		public TerminalNode CURRENT() { return getToken(SqlScriptParser.CURRENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterFrameBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitFrameBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitFrameBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameBoundContext frameBound() throws RecognitionException {
		FrameBoundContext _localctx = new FrameBoundContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_frameBound);
		int _la;
		try {
			setState(2372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,320,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2365);
				match(UNBOUNDED);
				setState(2366);
				((FrameBoundContext)_localctx).boundType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PRECEDING || _la==FOLLOWING) ) {
					((FrameBoundContext)_localctx).boundType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2367);
				((FrameBoundContext)_localctx).boundType = match(CURRENT);
				setState(2368);
				match(ROW);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2369);
				expression();
				setState(2370);
				((FrameBoundContext)_localctx).boundType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PRECEDING || _la==FOLLOWING) ) {
					((FrameBoundContext)_localctx).boundType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2374);
			identifier();
			setState(2379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,321,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2375);
					match(T__7);
					setState(2376);
					identifier();
					}
					} 
				}
				setState(2381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,321,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode ANTI() { return getToken(SqlScriptParser.ANTI, 0); }
		public TerminalNode FULL() { return getToken(SqlScriptParser.FULL, 0); }
		public TerminalNode INNER() { return getToken(SqlScriptParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(SqlScriptParser.LEFT, 0); }
		public TerminalNode SEMI() { return getToken(SqlScriptParser.SEMI, 0); }
		public TerminalNode RIGHT() { return getToken(SqlScriptParser.RIGHT, 0); }
		public TerminalNode NATURAL() { return getToken(SqlScriptParser.NATURAL, 0); }
		public TerminalNode JOIN() { return getToken(SqlScriptParser.JOIN, 0); }
		public TerminalNode CROSS() { return getToken(SqlScriptParser.CROSS, 0); }
		public TerminalNode ON() { return getToken(SqlScriptParser.ON, 0); }
		public TerminalNode UNION() { return getToken(SqlScriptParser.UNION, 0); }
		public TerminalNode INTERSECT() { return getToken(SqlScriptParser.INTERSECT, 0); }
		public TerminalNode EXCEPT() { return getToken(SqlScriptParser.EXCEPT, 0); }
		public TerminalNode SETMINUS() { return getToken(SqlScriptParser.SETMINUS, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_identifier);
		try {
			setState(2397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case OUTER:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
			case SQUARE_BRACKET_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2382);
				strictIdentifier();
				}
				break;
			case ANTI:
				enterOuterAlt(_localctx, 2);
				{
				setState(2383);
				match(ANTI);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2384);
				match(FULL);
				}
				break;
			case INNER:
				enterOuterAlt(_localctx, 4);
				{
				setState(2385);
				match(INNER);
				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2386);
				match(LEFT);
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 6);
				{
				setState(2387);
				match(SEMI);
				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2388);
				match(RIGHT);
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(2389);
				match(NATURAL);
				}
				break;
			case JOIN:
				enterOuterAlt(_localctx, 9);
				{
				setState(2390);
				match(JOIN);
				}
				break;
			case CROSS:
				enterOuterAlt(_localctx, 10);
				{
				setState(2391);
				match(CROSS);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 11);
				{
				setState(2392);
				match(ON);
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 12);
				{
				setState(2393);
				match(UNION);
				}
				break;
			case INTERSECT:
				enterOuterAlt(_localctx, 13);
				{
				setState(2394);
				match(INTERSECT);
				}
				break;
			case EXCEPT:
				enterOuterAlt(_localctx, 14);
				{
				setState(2395);
				match(EXCEPT);
				}
				break;
			case SETMINUS:
				enterOuterAlt(_localctx, 15);
				{
				setState(2396);
				match(SETMINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrictIdentifierContext extends ParserRuleContext {
		public StrictIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strictIdentifier; }
	 
		public StrictIdentifierContext() { }
		public void copyFrom(StrictIdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SquareBracketIdentifierContext extends StrictIdentifierContext {
		public TerminalNode SQUARE_BRACKET_IDENTIFIER() { return getToken(SqlScriptParser.SQUARE_BRACKET_IDENTIFIER, 0); }
		public SquareBracketIdentifierContext(StrictIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSquareBracketIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSquareBracketIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSquareBracketIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuotedIdentifierAlternativeContext extends StrictIdentifierContext {
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public QuotedIdentifierAlternativeContext(StrictIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQuotedIdentifierAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQuotedIdentifierAlternative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQuotedIdentifierAlternative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnquotedIdentifierContext extends StrictIdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlScriptParser.IDENTIFIER, 0); }
		public NonReservedContext nonReserved() {
			return getRuleContext(NonReservedContext.class,0);
		}
		public UnquotedIdentifierContext(StrictIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterUnquotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitUnquotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitUnquotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrictIdentifierContext strictIdentifier() throws RecognitionException {
		StrictIdentifierContext _localctx = new StrictIdentifierContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_strictIdentifier);
		try {
			setState(2403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2399);
				match(IDENTIFIER);
				}
				break;
			case SQUARE_BRACKET_IDENTIFIER:
				_localctx = new SquareBracketIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2400);
				match(SQUARE_BRACKET_IDENTIFIER);
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new QuotedIdentifierAlternativeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2401);
				quotedIdentifier();
				}
				break;
			case SELECT:
			case FROM:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case OUTER:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case IF:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case USING:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2402);
				nonReserved();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedIdentifierContext extends ParserRuleContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(SqlScriptParser.BACKQUOTED_IDENTIFIER, 0); }
		public QuotedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedIdentifierContext quotedIdentifier() throws RecognitionException {
		QuotedIdentifierContext _localctx = new QuotedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2405);
			match(BACKQUOTED_IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlScriptParser.DECIMAL_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BigIntLiteralContext extends NumberContext {
		public TerminalNode BIGINT_LITERAL() { return getToken(SqlScriptParser.BIGINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public BigIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterBigIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitBigIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitBigIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TinyIntLiteralContext extends NumberContext {
		public TerminalNode TINYINT_LITERAL() { return getToken(SqlScriptParser.TINYINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public TinyIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterTinyIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitTinyIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitTinyIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BigDecimalLiteralContext extends NumberContext {
		public TerminalNode BIGDECIMAL_LITERAL() { return getToken(SqlScriptParser.BIGDECIMAL_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public BigDecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterBigDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitBigDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitBigDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleLiteralContext extends NumberContext {
		public TerminalNode DOUBLE_LITERAL() { return getToken(SqlScriptParser.DOUBLE_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public DoubleLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlScriptParser.INTEGER_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallIntLiteralContext extends NumberContext {
		public TerminalNode SMALLINT_LITERAL() { return getToken(SqlScriptParser.SMALLINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(SqlScriptParser.MINUS, 0); }
		public SmallIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterSmallIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitSmallIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitSmallIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_number);
		int _la;
		try {
			setState(2435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,331,_ctx) ) {
			case 1:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2407);
					match(MINUS);
					}
				}

				setState(2410);
				match(DECIMAL_VALUE);
				}
				break;
			case 2:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2412);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2411);
					match(MINUS);
					}
				}

				setState(2414);
				match(INTEGER_VALUE);
				}
				break;
			case 3:
				_localctx = new BigIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2415);
					match(MINUS);
					}
				}

				setState(2418);
				match(BIGINT_LITERAL);
				}
				break;
			case 4:
				_localctx = new SmallIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2419);
					match(MINUS);
					}
				}

				setState(2422);
				match(SMALLINT_LITERAL);
				}
				break;
			case 5:
				_localctx = new TinyIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(2424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2423);
					match(MINUS);
					}
				}

				setState(2426);
				match(TINYINT_LITERAL);
				}
				break;
			case 6:
				_localctx = new DoubleLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(2428);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2427);
					match(MINUS);
					}
				}

				setState(2430);
				match(DOUBLE_LITERAL);
				}
				break;
			case 7:
				_localctx = new BigDecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(2432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(2431);
					match(MINUS);
					}
				}

				setState(2434);
				match(BIGDECIMAL_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonReservedContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(SqlScriptParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(SqlScriptParser.TABLES, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlScriptParser.COLUMNS, 0); }
		public TerminalNode COLUMN() { return getToken(SqlScriptParser.COLUMN, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlScriptParser.PARTITIONS, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlScriptParser.FUNCTIONS, 0); }
		public TerminalNode DATABASES() { return getToken(SqlScriptParser.DATABASES, 0); }
		public TerminalNode ADD() { return getToken(SqlScriptParser.ADD, 0); }
		public TerminalNode OVER() { return getToken(SqlScriptParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SqlScriptParser.PARTITION, 0); }
		public TerminalNode RANGE() { return getToken(SqlScriptParser.RANGE, 0); }
		public TerminalNode ROWS() { return getToken(SqlScriptParser.ROWS, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlScriptParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlScriptParser.FOLLOWING, 0); }
		public TerminalNode CURRENT() { return getToken(SqlScriptParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SqlScriptParser.ROW, 0); }
		public TerminalNode LAST() { return getToken(SqlScriptParser.LAST, 0); }
		public TerminalNode FIRST() { return getToken(SqlScriptParser.FIRST, 0); }
		public TerminalNode AFTER() { return getToken(SqlScriptParser.AFTER, 0); }
		public TerminalNode MAP() { return getToken(SqlScriptParser.MAP, 0); }
		public TerminalNode ARRAY() { return getToken(SqlScriptParser.ARRAY, 0); }
		public TerminalNode STRUCT() { return getToken(SqlScriptParser.STRUCT, 0); }
		public TerminalNode LATERAL() { return getToken(SqlScriptParser.LATERAL, 0); }
		public TerminalNode WINDOW() { return getToken(SqlScriptParser.WINDOW, 0); }
		public TerminalNode REDUCE() { return getToken(SqlScriptParser.REDUCE, 0); }
		public TerminalNode TRANSFORM() { return getToken(SqlScriptParser.TRANSFORM, 0); }
		public TerminalNode USING() { return getToken(SqlScriptParser.USING, 0); }
		public TerminalNode SERDE() { return getToken(SqlScriptParser.SERDE, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SqlScriptParser.SERDEPROPERTIES, 0); }
		public TerminalNode RECORDREADER() { return getToken(SqlScriptParser.RECORDREADER, 0); }
		public TerminalNode DELIMITED() { return getToken(SqlScriptParser.DELIMITED, 0); }
		public TerminalNode FIELDS() { return getToken(SqlScriptParser.FIELDS, 0); }
		public TerminalNode TERMINATED() { return getToken(SqlScriptParser.TERMINATED, 0); }
		public TerminalNode COLLECTION() { return getToken(SqlScriptParser.COLLECTION, 0); }
		public TerminalNode ITEMS() { return getToken(SqlScriptParser.ITEMS, 0); }
		public TerminalNode KEYS() { return getToken(SqlScriptParser.KEYS, 0); }
		public TerminalNode ESCAPED() { return getToken(SqlScriptParser.ESCAPED, 0); }
		public TerminalNode LINES() { return getToken(SqlScriptParser.LINES, 0); }
		public TerminalNode SEPARATED() { return getToken(SqlScriptParser.SEPARATED, 0); }
		public TerminalNode EXTENDED() { return getToken(SqlScriptParser.EXTENDED, 0); }
		public TerminalNode REFRESH() { return getToken(SqlScriptParser.REFRESH, 0); }
		public TerminalNode CLEAR() { return getToken(SqlScriptParser.CLEAR, 0); }
		public TerminalNode CACHE() { return getToken(SqlScriptParser.CACHE, 0); }
		public TerminalNode UNCACHE() { return getToken(SqlScriptParser.UNCACHE, 0); }
		public TerminalNode LAZY() { return getToken(SqlScriptParser.LAZY, 0); }
		public TerminalNode GLOBAL() { return getToken(SqlScriptParser.GLOBAL, 0); }
		public TerminalNode TEMPORARY() { return getToken(SqlScriptParser.TEMPORARY, 0); }
		public TerminalNode OPTIONS() { return getToken(SqlScriptParser.OPTIONS, 0); }
		public TerminalNode GROUPING() { return getToken(SqlScriptParser.GROUPING, 0); }
		public TerminalNode CUBE() { return getToken(SqlScriptParser.CUBE, 0); }
		public TerminalNode ROLLUP() { return getToken(SqlScriptParser.ROLLUP, 0); }
		public TerminalNode EXPLAIN() { return getToken(SqlScriptParser.EXPLAIN, 0); }
		public TerminalNode FORMAT() { return getToken(SqlScriptParser.FORMAT, 0); }
		public TerminalNode LOGICAL() { return getToken(SqlScriptParser.LOGICAL, 0); }
		public TerminalNode FORMATTED() { return getToken(SqlScriptParser.FORMATTED, 0); }
		public TerminalNode CODEGEN() { return getToken(SqlScriptParser.CODEGEN, 0); }
		public TerminalNode COST() { return getToken(SqlScriptParser.COST, 0); }
		public TerminalNode TABLESAMPLE() { return getToken(SqlScriptParser.TABLESAMPLE, 0); }
		public TerminalNode USE() { return getToken(SqlScriptParser.USE, 0); }
		public TerminalNode TO() { return getToken(SqlScriptParser.TO, 0); }
		public TerminalNode BUCKET() { return getToken(SqlScriptParser.BUCKET, 0); }
		public TerminalNode PERCENTLIT() { return getToken(SqlScriptParser.PERCENTLIT, 0); }
		public TerminalNode OUT() { return getToken(SqlScriptParser.OUT, 0); }
		public TerminalNode OF() { return getToken(SqlScriptParser.OF, 0); }
		public TerminalNode SET() { return getToken(SqlScriptParser.SET, 0); }
		public TerminalNode RESET() { return getToken(SqlScriptParser.RESET, 0); }
		public TerminalNode VIEW() { return getToken(SqlScriptParser.VIEW, 0); }
		public TerminalNode REPLACE() { return getToken(SqlScriptParser.REPLACE, 0); }
		public TerminalNode IF() { return getToken(SqlScriptParser.IF, 0); }
		public TerminalNode NO() { return getToken(SqlScriptParser.NO, 0); }
		public TerminalNode DATA() { return getToken(SqlScriptParser.DATA, 0); }
		public TerminalNode START() { return getToken(SqlScriptParser.START, 0); }
		public TerminalNode TRANSACTION() { return getToken(SqlScriptParser.TRANSACTION, 0); }
		public TerminalNode COMMIT() { return getToken(SqlScriptParser.COMMIT, 0); }
		public TerminalNode ROLLBACK() { return getToken(SqlScriptParser.ROLLBACK, 0); }
		public TerminalNode IGNORE() { return getToken(SqlScriptParser.IGNORE, 0); }
		public TerminalNode SORT() { return getToken(SqlScriptParser.SORT, 0); }
		public TerminalNode CLUSTER() { return getToken(SqlScriptParser.CLUSTER, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(SqlScriptParser.DISTRIBUTE, 0); }
		public TerminalNode UNSET() { return getToken(SqlScriptParser.UNSET, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SqlScriptParser.TBLPROPERTIES, 0); }
		public TerminalNode SKEWED() { return getToken(SqlScriptParser.SKEWED, 0); }
		public TerminalNode STORED() { return getToken(SqlScriptParser.STORED, 0); }
		public TerminalNode DIRECTORIES() { return getToken(SqlScriptParser.DIRECTORIES, 0); }
		public TerminalNode LOCATION() { return getToken(SqlScriptParser.LOCATION, 0); }
		public TerminalNode EXCHANGE() { return getToken(SqlScriptParser.EXCHANGE, 0); }
		public TerminalNode ARCHIVE() { return getToken(SqlScriptParser.ARCHIVE, 0); }
		public TerminalNode UNARCHIVE() { return getToken(SqlScriptParser.UNARCHIVE, 0); }
		public TerminalNode FILEFORMAT() { return getToken(SqlScriptParser.FILEFORMAT, 0); }
		public TerminalNode TOUCH() { return getToken(SqlScriptParser.TOUCH, 0); }
		public TerminalNode COMPACT() { return getToken(SqlScriptParser.COMPACT, 0); }
		public TerminalNode CONCATENATE() { return getToken(SqlScriptParser.CONCATENATE, 0); }
		public TerminalNode CHANGE() { return getToken(SqlScriptParser.CHANGE, 0); }
		public TerminalNode CASCADE() { return getToken(SqlScriptParser.CASCADE, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlScriptParser.RESTRICT, 0); }
		public TerminalNode BUCKETS() { return getToken(SqlScriptParser.BUCKETS, 0); }
		public TerminalNode CLUSTERED() { return getToken(SqlScriptParser.CLUSTERED, 0); }
		public TerminalNode SORTED() { return getToken(SqlScriptParser.SORTED, 0); }
		public TerminalNode PURGE() { return getToken(SqlScriptParser.PURGE, 0); }
		public TerminalNode INPUTFORMAT() { return getToken(SqlScriptParser.INPUTFORMAT, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(SqlScriptParser.OUTPUTFORMAT, 0); }
		public TerminalNode DBPROPERTIES() { return getToken(SqlScriptParser.DBPROPERTIES, 0); }
		public TerminalNode DFS() { return getToken(SqlScriptParser.DFS, 0); }
		public TerminalNode TRUNCATE() { return getToken(SqlScriptParser.TRUNCATE, 0); }
		public TerminalNode COMPUTE() { return getToken(SqlScriptParser.COMPUTE, 0); }
		public TerminalNode LIST() { return getToken(SqlScriptParser.LIST, 0); }
		public TerminalNode STATISTICS() { return getToken(SqlScriptParser.STATISTICS, 0); }
		public TerminalNode ANALYZE() { return getToken(SqlScriptParser.ANALYZE, 0); }
		public TerminalNode PARTITIONED() { return getToken(SqlScriptParser.PARTITIONED, 0); }
		public TerminalNode EXTERNAL() { return getToken(SqlScriptParser.EXTERNAL, 0); }
		public TerminalNode DEFINED() { return getToken(SqlScriptParser.DEFINED, 0); }
		public TerminalNode RECORDWRITER() { return getToken(SqlScriptParser.RECORDWRITER, 0); }
		public TerminalNode REVOKE() { return getToken(SqlScriptParser.REVOKE, 0); }
		public TerminalNode GRANT() { return getToken(SqlScriptParser.GRANT, 0); }
		public TerminalNode LOCK() { return getToken(SqlScriptParser.LOCK, 0); }
		public TerminalNode UNLOCK() { return getToken(SqlScriptParser.UNLOCK, 0); }
		public TerminalNode MSCK() { return getToken(SqlScriptParser.MSCK, 0); }
		public TerminalNode REPAIR() { return getToken(SqlScriptParser.REPAIR, 0); }
		public TerminalNode RECOVER() { return getToken(SqlScriptParser.RECOVER, 0); }
		public TerminalNode EXPORT() { return getToken(SqlScriptParser.EXPORT, 0); }
		public TerminalNode IMPORT() { return getToken(SqlScriptParser.IMPORT, 0); }
		public TerminalNode LOAD() { return getToken(SqlScriptParser.LOAD, 0); }
		public TerminalNode VALUES() { return getToken(SqlScriptParser.VALUES, 0); }
		public TerminalNode COMMENT() { return getToken(SqlScriptParser.COMMENT, 0); }
		public TerminalNode ROLE() { return getToken(SqlScriptParser.ROLE, 0); }
		public TerminalNode ROLES() { return getToken(SqlScriptParser.ROLES, 0); }
		public TerminalNode COMPACTIONS() { return getToken(SqlScriptParser.COMPACTIONS, 0); }
		public TerminalNode PRINCIPALS() { return getToken(SqlScriptParser.PRINCIPALS, 0); }
		public TerminalNode TRANSACTIONS() { return getToken(SqlScriptParser.TRANSACTIONS, 0); }
		public TerminalNode INDEX() { return getToken(SqlScriptParser.INDEX, 0); }
		public TerminalNode INDEXES() { return getToken(SqlScriptParser.INDEXES, 0); }
		public TerminalNode LOCKS() { return getToken(SqlScriptParser.LOCKS, 0); }
		public TerminalNode OPTION() { return getToken(SqlScriptParser.OPTION, 0); }
		public TerminalNode LOCAL() { return getToken(SqlScriptParser.LOCAL, 0); }
		public TerminalNode INPATH() { return getToken(SqlScriptParser.INPATH, 0); }
		public TerminalNode ASC() { return getToken(SqlScriptParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlScriptParser.DESC, 0); }
		public TerminalNode LIMIT() { return getToken(SqlScriptParser.LIMIT, 0); }
		public TerminalNode RENAME() { return getToken(SqlScriptParser.RENAME, 0); }
		public TerminalNode SETS() { return getToken(SqlScriptParser.SETS, 0); }
		public TerminalNode AT() { return getToken(SqlScriptParser.AT, 0); }
		public TerminalNode NULLS() { return getToken(SqlScriptParser.NULLS, 0); }
		public TerminalNode OVERWRITE() { return getToken(SqlScriptParser.OVERWRITE, 0); }
		public TerminalNode ALL() { return getToken(SqlScriptParser.ALL, 0); }
		public TerminalNode ALTER() { return getToken(SqlScriptParser.ALTER, 0); }
		public TerminalNode AS() { return getToken(SqlScriptParser.AS, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlScriptParser.BETWEEN, 0); }
		public TerminalNode BY() { return getToken(SqlScriptParser.BY, 0); }
		public TerminalNode CREATE() { return getToken(SqlScriptParser.CREATE, 0); }
		public TerminalNode DELETE() { return getToken(SqlScriptParser.DELETE, 0); }
		public TerminalNode DESCRIBE() { return getToken(SqlScriptParser.DESCRIBE, 0); }
		public TerminalNode DROP() { return getToken(SqlScriptParser.DROP, 0); }
		public TerminalNode EXISTS() { return getToken(SqlScriptParser.EXISTS, 0); }
		public TerminalNode FALSE() { return getToken(SqlScriptParser.FALSE, 0); }
		public TerminalNode FOR() { return getToken(SqlScriptParser.FOR, 0); }
		public TerminalNode GROUP() { return getToken(SqlScriptParser.GROUP, 0); }
		public TerminalNode IN() { return getToken(SqlScriptParser.IN, 0); }
		public TerminalNode INSERT() { return getToken(SqlScriptParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SqlScriptParser.INTO, 0); }
		public TerminalNode IS() { return getToken(SqlScriptParser.IS, 0); }
		public TerminalNode LIKE() { return getToken(SqlScriptParser.LIKE, 0); }
		public TerminalNode NULL() { return getToken(SqlScriptParser.NULL, 0); }
		public TerminalNode ORDER() { return getToken(SqlScriptParser.ORDER, 0); }
		public TerminalNode OUTER() { return getToken(SqlScriptParser.OUTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlScriptParser.TABLE, 0); }
		public TerminalNode TRUE() { return getToken(SqlScriptParser.TRUE, 0); }
		public TerminalNode WITH() { return getToken(SqlScriptParser.WITH, 0); }
		public TerminalNode RLIKE() { return getToken(SqlScriptParser.RLIKE, 0); }
		public TerminalNode AND() { return getToken(SqlScriptParser.AND, 0); }
		public TerminalNode CASE() { return getToken(SqlScriptParser.CASE, 0); }
		public TerminalNode CAST() { return getToken(SqlScriptParser.CAST, 0); }
		public TerminalNode DISTINCT() { return getToken(SqlScriptParser.DISTINCT, 0); }
		public TerminalNode DIV() { return getToken(SqlScriptParser.DIV, 0); }
		public TerminalNode ELSE() { return getToken(SqlScriptParser.ELSE, 0); }
		public TerminalNode END() { return getToken(SqlScriptParser.END, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlScriptParser.FUNCTION, 0); }
		public TerminalNode INTERVAL() { return getToken(SqlScriptParser.INTERVAL, 0); }
		public TerminalNode MACRO() { return getToken(SqlScriptParser.MACRO, 0); }
		public TerminalNode OR() { return getToken(SqlScriptParser.OR, 0); }
		public TerminalNode STRATIFY() { return getToken(SqlScriptParser.STRATIFY, 0); }
		public TerminalNode THEN() { return getToken(SqlScriptParser.THEN, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SqlScriptParser.UNBOUNDED, 0); }
		public TerminalNode WHEN() { return getToken(SqlScriptParser.WHEN, 0); }
		public TerminalNode DATABASE() { return getToken(SqlScriptParser.DATABASE, 0); }
		public TerminalNode SELECT() { return getToken(SqlScriptParser.SELECT, 0); }
		public TerminalNode FROM() { return getToken(SqlScriptParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(SqlScriptParser.WHERE, 0); }
		public TerminalNode HAVING() { return getToken(SqlScriptParser.HAVING, 0); }
		public TerminalNode NOT() { return getToken(SqlScriptParser.NOT, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(SqlScriptParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SqlScriptParser.CURRENT_TIMESTAMP, 0); }
		public NonReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).enterNonReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlScriptListener ) ((SqlScriptListener)listener).exitNonReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlScriptVisitor ) return ((SqlScriptVisitor<? extends T>)visitor).visitNonReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonReservedContext nonReserved() throws RecognitionException {
		NonReservedContext _localctx = new NonReservedContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_nonReserved);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2437);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << FROM) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NULLS) | (1L << ASC) | (1L << DESC) | (1L << FOR) | (1L << INTERVAL) | (1L << CASE) | (1L << WHEN) | (1L << THEN) | (1L << ELSE) | (1L << END) | (1L << OUTER))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LATERAL - 65)) | (1L << (WINDOW - 65)) | (1L << (OVER - 65)) | (1L << (PARTITION - 65)) | (1L << (RANGE - 65)) | (1L << (ROWS - 65)) | (1L << (UNBOUNDED - 65)) | (1L << (PRECEDING - 65)) | (1L << (FOLLOWING - 65)) | (1L << (CURRENT - 65)) | (1L << (FIRST - 65)) | (1L << (AFTER - 65)) | (1L << (LAST - 65)) | (1L << (ROW - 65)) | (1L << (WITH - 65)) | (1L << (VALUES - 65)) | (1L << (CREATE - 65)) | (1L << (TABLE - 65)) | (1L << (VIEW - 65)) | (1L << (REPLACE - 65)) | (1L << (INSERT - 65)) | (1L << (DELETE - 65)) | (1L << (INTO - 65)) | (1L << (DESCRIBE - 65)) | (1L << (EXPLAIN - 65)) | (1L << (FORMAT - 65)) | (1L << (LOGICAL - 65)) | (1L << (CODEGEN - 65)) | (1L << (COST - 65)) | (1L << (CAST - 65)) | (1L << (SHOW - 65)) | (1L << (TABLES - 65)) | (1L << (COLUMNS - 65)) | (1L << (COLUMN - 65)) | (1L << (USE - 65)) | (1L << (PARTITIONS - 65)) | (1L << (FUNCTIONS - 65)) | (1L << (DROP - 65)) | (1L << (TO - 65)) | (1L << (TABLESAMPLE - 65)) | (1L << (STRATIFY - 65)) | (1L << (ALTER - 65)) | (1L << (RENAME - 65)) | (1L << (ARRAY - 65)) | (1L << (MAP - 65)) | (1L << (STRUCT - 65)) | (1L << (COMMENT - 65)) | (1L << (SET - 65)) | (1L << (RESET - 65)) | (1L << (DATA - 65)) | (1L << (START - 65)) | (1L << (TRANSACTION - 65)) | (1L << (COMMIT - 65)) | (1L << (ROLLBACK - 65)) | (1L << (MACRO - 65)) | (1L << (IGNORE - 65)) | (1L << (IF - 65)))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (DIV - 139)) | (1L << (PERCENTLIT - 139)) | (1L << (BUCKET - 139)) | (1L << (OUT - 139)) | (1L << (OF - 139)) | (1L << (SORT - 139)) | (1L << (CLUSTER - 139)) | (1L << (DISTRIBUTE - 139)) | (1L << (OVERWRITE - 139)) | (1L << (TRANSFORM - 139)) | (1L << (REDUCE - 139)) | (1L << (USING - 139)) | (1L << (SERDE - 139)) | (1L << (SERDEPROPERTIES - 139)) | (1L << (RECORDREADER - 139)) | (1L << (RECORDWRITER - 139)) | (1L << (DELIMITED - 139)) | (1L << (FIELDS - 139)) | (1L << (TERMINATED - 139)) | (1L << (COLLECTION - 139)) | (1L << (ITEMS - 139)) | (1L << (KEYS - 139)) | (1L << (ESCAPED - 139)) | (1L << (LINES - 139)) | (1L << (SEPARATED - 139)) | (1L << (FUNCTION - 139)) | (1L << (EXTENDED - 139)) | (1L << (REFRESH - 139)) | (1L << (CLEAR - 139)) | (1L << (CACHE - 139)) | (1L << (UNCACHE - 139)) | (1L << (LAZY - 139)) | (1L << (FORMATTED - 139)) | (1L << (GLOBAL - 139)) | (1L << (TEMPORARY - 139)) | (1L << (OPTIONS - 139)) | (1L << (UNSET - 139)) | (1L << (TBLPROPERTIES - 139)) | (1L << (DBPROPERTIES - 139)) | (1L << (BUCKETS - 139)) | (1L << (SKEWED - 139)) | (1L << (STORED - 139)) | (1L << (DIRECTORIES - 139)) | (1L << (LOCATION - 139)) | (1L << (EXCHANGE - 139)) | (1L << (ARCHIVE - 139)) | (1L << (UNARCHIVE - 139)) | (1L << (FILEFORMAT - 139)) | (1L << (TOUCH - 139)) | (1L << (COMPACT - 139)) | (1L << (CONCATENATE - 139)) | (1L << (CHANGE - 139)) | (1L << (CASCADE - 139)) | (1L << (RESTRICT - 139)) | (1L << (CLUSTERED - 139)) | (1L << (SORTED - 139)) | (1L << (PURGE - 139)) | (1L << (INPUTFORMAT - 139)) | (1L << (OUTPUTFORMAT - 139)))) != 0) || ((((_la - 203)) & ~0x3f) == 0 && ((1L << (_la - 203)) & ((1L << (DATABASE - 203)) | (1L << (DATABASES - 203)) | (1L << (DFS - 203)) | (1L << (TRUNCATE - 203)) | (1L << (ANALYZE - 203)) | (1L << (COMPUTE - 203)) | (1L << (LIST - 203)) | (1L << (STATISTICS - 203)) | (1L << (PARTITIONED - 203)) | (1L << (EXTERNAL - 203)) | (1L << (DEFINED - 203)) | (1L << (REVOKE - 203)) | (1L << (GRANT - 203)) | (1L << (LOCK - 203)) | (1L << (UNLOCK - 203)) | (1L << (MSCK - 203)) | (1L << (REPAIR - 203)) | (1L << (RECOVER - 203)) | (1L << (EXPORT - 203)) | (1L << (IMPORT - 203)) | (1L << (LOAD - 203)) | (1L << (ROLE - 203)) | (1L << (ROLES - 203)) | (1L << (COMPACTIONS - 203)) | (1L << (PRINCIPALS - 203)) | (1L << (TRANSACTIONS - 203)) | (1L << (INDEX - 203)) | (1L << (INDEXES - 203)) | (1L << (LOCKS - 203)) | (1L << (OPTION - 203)) | (1L << (LOCAL - 203)) | (1L << (INPATH - 203)) | (1L << (CURRENT_DATE - 203)) | (1L << (CURRENT_TIMESTAMP - 203)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 48:
			return queryTerm_sempred((QueryTermContext)_localctx, predIndex);
		case 78:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		case 81:
			return valueExpression_sempred((ValueExpressionContext)_localctx, predIndex);
		case 82:
			return primaryExpression_sempred((PrimaryExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean queryTerm_sempred(QueryTermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean valueExpression_sempred(ValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean primaryExpression_sempred(PrimaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0107\u098a\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\3\2\3\2\7\2\u00df\n\2\f\2\16\2\u00e2\13\2\3\2\3\2"+
		"\3\2\5\2\u00e7\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00f2\n\4\3"+
		"\5\3\5\3\5\3\5\5\5\u00f8\n\5\3\5\3\5\5\5\u00fc\n\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7\u010b\n\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\7\t\u0113\n\t\f\t\16\t\u0116\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\n"+
		"\u0120\n\n\3\n\3\n\5\n\u0124\n\n\3\13\3\13\3\13\3\13\5\13\u012a\n\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0133\n\f\3\r\3\r\3\r\3\r\7\r\u0139\n\r"+
		"\f\r\16\r\u013c\13\r\3\r\3\r\3\r\3\r\5\r\u0142\n\r\3\16\3\16\3\16\3\16"+
		"\3\17\5\17\u0149\n\17\3\17\3\17\5\17\u014d\n\17\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0166\n\25\3\25\3\25\3\25\5\25\u016b\n\25"+
		"\3\25\5\25\u016e\n\25\3\25\3\25\3\25\5\25\u0173\n\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0180\n\25\3\25\3\25\5\25"+
		"\u0184\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u018b\n\25\3\25\3\25\3\25\5"+
		"\25\u0190\n\25\3\25\3\25\3\25\5\25\u0195\n\25\3\25\5\25\u0198\n\25\3\25"+
		"\5\25\u019b\n\25\3\25\3\25\5\25\u019f\n\25\3\25\5\25\u01a2\n\25\3\25\5"+
		"\25\u01a5\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u01ac\n\25\3\25\3\25\5\25"+
		"\u01b0\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01b8\n\25\3\25\5\25\u01bb"+
		"\n\25\3\25\5\25\u01be\n\25\3\25\5\25\u01c1\n\25\3\25\5\25\u01c4\n\25\3"+
		"\25\5\25\u01c7\n\25\3\25\3\25\5\25\u01cb\n\25\3\25\5\25\u01ce\n\25\3\25"+
		"\5\25\u01d1\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u01d8\n\25\3\25\3\25\3"+
		"\25\3\25\5\25\u01de\n\25\3\25\3\25\3\25\3\25\5\25\u01e4\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u01ec\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u020c\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0214\n\25\3\25\3\25\5\25\u0218\n\25\3\25\3"+
		"\25\3\25\5\25\u021d\n\25\3\25\3\25\3\25\3\25\5\25\u0223\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u022b\n\25\3\25\3\25\3\25\3\25\5\25\u0231\n"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u023e"+
		"\n\25\3\25\6\25\u0241\n\25\r\25\16\25\u0242\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u024c\n\25\3\25\6\25\u024f\n\25\r\25\16\25\u0250\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0261"+
		"\n\25\3\25\3\25\3\25\7\25\u0266\n\25\f\25\16\25\u0269\13\25\3\25\5\25"+
		"\u026c\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0274\n\25\3\25\3\25\3"+
		"\25\7\25\u0279\n\25\f\25\16\25\u027c\13\25\3\25\3\25\3\25\3\25\5\25\u0282"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0291\n\25\3\25\3\25\5\25\u0295\n\25\3\25\3\25\3\25\3\25\5\25\u029b"+
		"\n\25\3\25\3\25\3\25\3\25\5\25\u02a1\n\25\3\25\5\25\u02a4\n\25\3\25\5"+
		"\25\u02a7\n\25\3\25\3\25\3\25\3\25\5\25\u02ad\n\25\3\25\3\25\5\25\u02b1"+
		"\n\25\3\25\3\25\5\25\u02b5\n\25\3\25\3\25\3\25\5\25\u02ba\n\25\3\25\3"+
		"\25\5\25\u02be\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u02c6\n\25\3\25"+
		"\5\25\u02c9\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u02d2\n\25\3"+
		"\25\3\25\3\25\5\25\u02d7\n\25\3\25\3\25\3\25\3\25\5\25\u02dd\n\25\3\25"+
		"\3\25\3\25\3\25\5\25\u02e3\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u02ed\n\25\f\25\16\25\u02f0\13\25\5\25\u02f2\n\25\3\25\3\25\5\25"+
		"\u02f6\n\25\3\25\3\25\3\25\5\25\u02fb\n\25\3\25\3\25\3\25\5\25\u0300\n"+
		"\25\3\25\3\25\3\25\3\25\3\25\5\25\u0307\n\25\3\25\5\25\u030a\n\25\3\25"+
		"\5\25\u030d\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u0314\n\25\3\25\3\25\3"+
		"\25\5\25\u0319\n\25\3\25\3\25\3\25\3\25\5\25\u031f\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0328\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u0330\n\25\3\25\3\25\3\25\3\25\5\25\u0336\n\25\3\25\3\25\5\25\u033a\n"+
		"\25\3\25\3\25\5\25\u033e\n\25\3\25\3\25\5\25\u0342\n\25\5\25\u0344\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u034d\n\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0353\n\25\3\25\3\25\3\25\5\25\u0358\n\25\3\25\5\25\u035b\n\25\3"+
		"\25\3\25\5\25\u035f\n\25\3\25\5\25\u0362\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u0369\n\25\f\25\16\25\u036c\13\25\3\25\3\25\5\25\u0370\n\25\3\25"+
		"\3\25\3\25\5\25\u0375\n\25\3\25\5\25\u0378\n\25\3\25\3\25\3\25\3\25\5"+
		"\25\u037e\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0386\n\25\3\25\3\25"+
		"\3\25\5\25\u038b\n\25\3\25\3\25\3\25\3\25\5\25\u0391\n\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0397\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u03a0"+
		"\n\25\f\25\16\25\u03a3\13\25\3\25\3\25\3\25\7\25\u03a8\n\25\f\25\16\25"+
		"\u03ab\13\25\3\25\3\25\7\25\u03af\n\25\f\25\16\25\u03b2\13\25\3\25\3\25"+
		"\3\25\7\25\u03b7\n\25\f\25\16\25\u03ba\13\25\5\25\u03bc\n\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u03c4\n\26\3\26\3\26\5\26\u03c8\n\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u03cf\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0443\n\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u044b\n\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0453\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u045c\n\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0468\n\26\3\27\3\27"+
		"\5\27\u046c\n\27\3\27\5\27\u046f\n\27\3\27\3\27\3\27\3\27\5\27\u0475\n"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u047f\n\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u048b\n\31\3\31\3\31\3\31"+
		"\5\31\u0490\n\31\3\32\3\32\3\32\3\33\5\33\u0496\n\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u04a2\n\34\5\34\u04a4\n\34\3\34"+
		"\3\34\3\34\5\34\u04a9\n\34\3\34\3\34\5\34\u04ad\n\34\5\34\u04af\n\34\3"+
		"\35\3\35\5\35\u04b3\n\35\3\36\3\36\3\36\3\36\3\36\7\36\u04ba\n\36\f\36"+
		"\16\36\u04bd\13\36\3\36\3\36\3\37\3\37\3\37\5\37\u04c4\n\37\3 \3 \3 \3"+
		" \3 \5 \u04cb\n \3!\3!\3!\3!\5!\u04d1\n!\7!\u04d3\n!\f!\16!\u04d6\13!"+
		"\3\"\3\"\3\"\3\"\7\"\u04dc\n\"\f\"\16\"\u04df\13\"\3#\3#\5#\u04e3\n#\3"+
		"#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\7%\u04f0\n%\f%\16%\u04f3\13%\3%\3%\3&"+
		"\3&\5&\u04f9\n&\3&\5&\u04fc\n&\3\'\3\'\3\'\7\'\u0501\n\'\f\'\16\'\u0504"+
		"\13\'\3\'\5\'\u0507\n\'\3(\3(\3(\3(\5(\u050d\n(\3)\3)\3)\3)\7)\u0513\n"+
		")\f)\16)\u0516\13)\3)\3)\3*\3*\3*\3*\7*\u051e\n*\f*\16*\u0521\13*\3*\3"+
		"*\3+\3+\3+\3+\3+\3+\5+\u052b\n+\3,\3,\3,\3,\3,\5,\u0532\n,\3-\3-\3-\3"+
		"-\5-\u0538\n-\3.\3.\3.\3/\5/\u053e\n/\3/\3/\3/\3/\3/\6/\u0545\n/\r/\16"+
		"/\u0546\5/\u0549\n/\3\60\3\60\3\60\3\60\3\60\7\60\u0550\n\60\f\60\16\60"+
		"\u0553\13\60\5\60\u0555\n\60\3\60\3\60\3\60\3\60\3\60\7\60\u055c\n\60"+
		"\f\60\16\60\u055f\13\60\5\60\u0561\n\60\3\60\3\60\3\60\3\60\3\60\7\60"+
		"\u0568\n\60\f\60\16\60\u056b\13\60\5\60\u056d\n\60\3\60\3\60\3\60\3\60"+
		"\3\60\7\60\u0574\n\60\f\60\16\60\u0577\13\60\5\60\u0579\n\60\3\60\5\60"+
		"\u057c\n\60\3\60\3\60\5\60\u0580\n\60\3\61\5\61\u0583\n\61\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u058e\n\62\3\62\7\62\u0591\n\62"+
		"\f\62\16\62\u0594\13\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u059e"+
		"\n\63\3\64\3\64\5\64\u05a2\n\64\3\64\3\64\5\64\u05a6\n\64\3\65\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u05b2\n\65\3\65\5\65\u05b5"+
		"\n\65\3\65\3\65\5\65\u05b9\n\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\5\65\u05c3\n\65\3\65\3\65\5\65\u05c7\n\65\5\65\u05c9\n\65\3\65\5\65\u05cc"+
		"\n\65\3\65\3\65\5\65\u05d0\n\65\3\65\5\65\u05d3\n\65\3\65\3\65\5\65\u05d7"+
		"\n\65\3\65\3\65\7\65\u05db\n\65\f\65\16\65\u05de\13\65\3\65\5\65\u05e1"+
		"\n\65\3\65\3\65\5\65\u05e5\n\65\3\65\3\65\3\65\5\65\u05ea\n\65\3\65\5"+
		"\65\u05ed\n\65\5\65\u05ef\n\65\3\65\7\65\u05f2\n\65\f\65\16\65\u05f5\13"+
		"\65\3\65\3\65\5\65\u05f9\n\65\3\65\5\65\u05fc\n\65\3\65\3\65\5\65\u0600"+
		"\n\65\3\65\5\65\u0603\n\65\5\65\u0605\n\65\3\66\3\66\3\66\5\66\u060a\n"+
		"\66\3\66\7\66\u060d\n\66\f\66\16\66\u0610\13\66\3\66\3\66\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\7\67\u061a\n\67\f\67\16\67\u061d\13\67\3\67\3\67\5"+
		"\67\u0621\n\67\38\38\38\38\78\u0627\n8\f8\168\u062a\138\38\78\u062d\n"+
		"8\f8\168\u0630\138\39\39\39\39\39\79\u0637\n9\f9\169\u063a\139\39\39\3"+
		"9\39\39\39\39\39\39\39\79\u0646\n9\f9\169\u0649\139\39\39\59\u064d\n9"+
		"\3:\3:\3:\3:\7:\u0653\n:\f:\16:\u0656\13:\5:\u0658\n:\3:\3:\5:\u065c\n"+
		":\3;\3;\3;\5;\u0661\n;\3;\3;\3;\3;\3;\7;\u0668\n;\f;\16;\u066b\13;\5;"+
		"\u066d\n;\3;\3;\3;\5;\u0672\n;\3;\3;\3;\7;\u0677\n;\f;\16;\u067a\13;\5"+
		";\u067c\n;\3<\3<\3=\3=\7=\u0682\n=\f=\16=\u0685\13=\3>\3>\3>\3>\5>\u068b"+
		"\n>\3>\3>\3>\3>\3>\5>\u0692\n>\3?\5?\u0695\n?\3?\3?\3?\5?\u069a\n?\3?"+
		"\3?\3?\3?\5?\u06a0\n?\3?\3?\5?\u06a4\n?\3?\5?\u06a7\n?\3?\5?\u06aa\n?"+
		"\3@\3@\3@\3@\3@\3@\3@\7@\u06b3\n@\f@\16@\u06b6\13@\3@\3@\5@\u06ba\n@\3"+
		"A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u06cf\nA\5"+
		"A\u06d1\nA\5A\u06d3\nA\3A\3A\3B\3B\3B\3B\3C\3C\3C\7C\u06de\nC\fC\16C\u06e1"+
		"\13C\3D\3D\3D\3D\7D\u06e7\nD\fD\16D\u06ea\13D\3D\3D\3E\3E\5E\u06f0\nE"+
		"\3F\3F\3F\3F\7F\u06f6\nF\fF\16F\u06f9\13F\3F\3F\3G\3G\3G\5G\u0700\nG\3"+
		"H\3H\5H\u0704\nH\3H\5H\u0707\nH\3H\5H\u070a\nH\3H\3H\3H\3H\5H\u0710\n"+
		"H\3H\5H\u0713\nH\3H\5H\u0716\nH\3H\3H\3H\3H\5H\u071c\nH\3H\5H\u071f\n"+
		"H\3H\5H\u0722\nH\3H\3H\3H\3H\3H\3H\7H\u072a\nH\fH\16H\u072d\13H\5H\u072f"+
		"\nH\3H\3H\5H\u0733\nH\3I\3I\3I\3I\7I\u0739\nI\fI\16I\u073c\13I\3I\5I\u073f"+
		"\nI\3I\3I\5I\u0743\nI\5I\u0745\nI\3J\3J\3J\3J\3J\3J\3J\5J\u074e\nJ\3J"+
		"\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u075a\nJ\5J\u075c\nJ\3J\3J\3J\3J\3J\5J"+
		"\u0763\nJ\3J\3J\3J\3J\3J\5J\u076a\nJ\3J\3J\3J\3J\5J\u0770\nJ\3J\3J\3J"+
		"\3J\5J\u0776\nJ\5J\u0778\nJ\3K\3K\3K\5K\u077d\nK\3K\3K\3L\3L\3L\5L\u0784"+
		"\nL\3L\3L\3M\3M\5M\u078a\nM\3M\3M\5M\u078e\nM\5M\u0790\nM\3N\3N\3N\7N"+
		"\u0795\nN\fN\16N\u0798\13N\3O\3O\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3"+
		"P\5P\u07a9\nP\3P\3P\3P\3P\3P\3P\7P\u07b1\nP\fP\16P\u07b4\13P\3Q\3Q\5Q"+
		"\u07b8\nQ\3R\5R\u07bb\nR\3R\3R\3R\3R\3R\3R\5R\u07c3\nR\3R\3R\3R\3R\3R"+
		"\7R\u07ca\nR\fR\16R\u07cd\13R\3R\3R\3R\5R\u07d2\nR\3R\3R\3R\3R\3R\3R\5"+
		"R\u07da\nR\3R\3R\3R\3R\5R\u07e0\nR\3R\5R\u07e3\nR\3S\3S\3S\3S\5S\u07e9"+
		"\nS\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\7S\u07fe"+
		"\nS\fS\16S\u0801\13S\3T\3T\3T\3T\6T\u0807\nT\rT\16T\u0808\3T\3T\5T\u080d"+
		"\nT\3T\3T\3T\3T\3T\6T\u0814\nT\rT\16T\u0815\3T\3T\5T\u081a\nT\3T\3T\3"+
		"T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\7T\u082a\nT\fT\16T\u082d\13T\5T\u082f"+
		"\nT\3T\3T\3T\3T\3T\3T\5T\u0837\nT\3T\3T\3T\3T\3T\3T\3T\5T\u0840\nT\3T"+
		"\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\6T\u084e\nT\rT\16T\u084f\3T\3T\3T\3"+
		"T\3T\3T\3T\3T\3T\5T\u085b\nT\3T\3T\3T\7T\u0860\nT\fT\16T\u0863\13T\5T"+
		"\u0865\nT\3T\3T\3T\5T\u086a\nT\3T\3T\3T\3T\3T\5T\u0871\nT\3T\3T\3T\3T"+
		"\3T\3T\3T\3T\7T\u087b\nT\fT\16T\u087e\13T\3U\3U\3U\3U\3U\3U\3U\3U\6U\u0888"+
		"\nU\rU\16U\u0889\5U\u088c\nU\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\7Z\u0898\n"+
		"Z\fZ\16Z\u089b\13Z\3[\3[\3[\3[\5[\u08a1\n[\3\\\5\\\u08a4\n\\\3\\\3\\\5"+
		"\\\u08a8\n\\\3]\3]\3]\5]\u08ad\n]\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^"+
		"\3^\3^\3^\5^\u08be\n^\3^\3^\5^\u08c2\n^\3^\3^\3^\3^\3^\7^\u08c9\n^\f^"+
		"\16^\u08cc\13^\3^\5^\u08cf\n^\5^\u08d1\n^\3_\3_\3_\7_\u08d6\n_\f_\16_"+
		"\u08d9\13_\3`\3`\3`\3`\5`\u08df\n`\3a\3a\3a\7a\u08e4\na\fa\16a\u08e7\13"+
		"a\3b\3b\3b\3b\3b\5b\u08ee\nb\3c\3c\3c\3c\3c\3d\3d\3d\3d\7d\u08f9\nd\f"+
		"d\16d\u08fc\13d\3e\3e\3e\3e\3f\3f\3f\3f\3f\3f\3f\7f\u0909\nf\ff\16f\u090c"+
		"\13f\3f\3f\3f\3f\3f\7f\u0913\nf\ff\16f\u0916\13f\5f\u0918\nf\3f\3f\3f"+
		"\3f\3f\7f\u091f\nf\ff\16f\u0922\13f\5f\u0924\nf\5f\u0926\nf\3f\5f\u0929"+
		"\nf\3f\5f\u092c\nf\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\5g"+
		"\u093e\ng\3h\3h\3h\3h\3h\3h\3h\5h\u0947\nh\3i\3i\3i\7i\u094c\ni\fi\16"+
		"i\u094f\13i\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\5j\u0960\nj\3"+
		"k\3k\3k\3k\5k\u0966\nk\3l\3l\3m\5m\u096b\nm\3m\3m\5m\u096f\nm\3m\3m\5"+
		"m\u0973\nm\3m\3m\5m\u0977\nm\3m\3m\5m\u097b\nm\3m\3m\5m\u097f\nm\3m\3"+
		"m\5m\u0983\nm\3m\5m\u0986\nm\3n\3n\3n\7\u036a\u03a1\u03a9\u03b0\u03b8"+
		"\6b\u009e\u00a4\u00a6o\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\2\33\3\2\u00c6\u00c7\3\2TU\5\2]_"+
		"\u00ab\u00ab\u00b1\u00b1\4\2\22\22$$\4\2\61\61ZZ\4\2\u00ab\u00ab\u00b1"+
		"\u00b1\4\2\23\23\u00d3\u00d3\3\2il\3\2\60\61\4\2MMOO\3\2\25\26\3\2\u00fa"+
		"\u00fb\3\2)*\4\2\u0088\u0089\u008e\u008e\3\2\u008a\u008d\3\2\u0088\u0089"+
		"\3\2\u00ee\u00ef\3\2\u0080\u0087\3\2\u0088\u0091\3\2\"%\3\2-.\4\2FF\u0098"+
		"\u0098\4\2\36\36\u0096\u0096\3\2JK\n\2\218;;Chm\177\u008d\u008d\u0092"+
		"\u00b3\u00b5\u00ea\u00ec\u00ef\2\u0b18\2\u00e0\3\2\2\2\4\u00e8\3\2\2\2"+
		"\6\u00eb\3\2\2\2\b\u00f3\3\2\2\2\n\u0100\3\2\2\2\f\u0105\3\2\2\2\16\u010c"+
		"\3\2\2\2\20\u010f\3\2\2\2\22\u011d\3\2\2\2\24\u0129\3\2\2\2\26\u0132\3"+
		"\2\2\2\30\u0141\3\2\2\2\32\u0143\3\2\2\2\34\u0148\3\2\2\2\36\u014e\3\2"+
		"\2\2 \u0151\3\2\2\2\"\u0154\3\2\2\2$\u0157\3\2\2\2&\u015a\3\2\2\2(\u03bb"+
		"\3\2\2\2*\u0467\3\2\2\2,\u0469\3\2\2\2.\u0478\3\2\2\2\60\u0484\3\2\2\2"+
		"\62\u0491\3\2\2\2\64\u0495\3\2\2\2\66\u04ae\3\2\2\28\u04b0\3\2\2\2:\u04b4"+
		"\3\2\2\2<\u04c0\3\2\2\2>\u04ca\3\2\2\2@\u04cc\3\2\2\2B\u04d7\3\2\2\2D"+
		"\u04e0\3\2\2\2F\u04e8\3\2\2\2H\u04eb\3\2\2\2J\u04f6\3\2\2\2L\u0506\3\2"+
		"\2\2N\u050c\3\2\2\2P\u050e\3\2\2\2R\u0519\3\2\2\2T\u052a\3\2\2\2V\u0531"+
		"\3\2\2\2X\u0533\3\2\2\2Z\u0539\3\2\2\2\\\u0548\3\2\2\2^\u0554\3\2\2\2"+
		"`\u0582\3\2\2\2b\u0587\3\2\2\2d\u059d\3\2\2\2f\u059f\3\2\2\2h\u0604\3"+
		"\2\2\2j\u0606\3\2\2\2l\u0620\3\2\2\2n\u0622\3\2\2\2p\u0631\3\2\2\2r\u065b"+
		"\3\2\2\2t\u065d\3\2\2\2v\u067d\3\2\2\2x\u067f\3\2\2\2z\u0691\3\2\2\2|"+
		"\u06a9\3\2\2\2~\u06b9\3\2\2\2\u0080\u06bb\3\2\2\2\u0082\u06d6\3\2\2\2"+
		"\u0084\u06da\3\2\2\2\u0086\u06e2\3\2\2\2\u0088\u06ed\3\2\2\2\u008a\u06f1"+
		"\3\2\2\2\u008c\u06fc\3\2\2\2\u008e\u0732\3\2\2\2\u0090\u0734\3\2\2\2\u0092"+
		"\u0777\3\2\2\2\u0094\u077c\3\2\2\2\u0096\u0783\3\2\2\2\u0098\u0787\3\2"+
		"\2\2\u009a\u0791\3\2\2\2\u009c\u0799\3\2\2\2\u009e\u07a8\3\2\2\2\u00a0"+
		"\u07b5\3\2\2\2\u00a2\u07e2\3\2\2\2\u00a4\u07e8\3\2\2\2\u00a6\u0870\3\2"+
		"\2\2\u00a8\u088b\3\2\2\2\u00aa\u088d\3\2\2\2\u00ac\u088f\3\2\2\2\u00ae"+
		"\u0891\3\2\2\2\u00b0\u0893\3\2\2\2\u00b2\u0895\3\2\2\2\u00b4\u089c\3\2"+
		"\2\2\u00b6\u08a7\3\2\2\2\u00b8\u08ac\3\2\2\2\u00ba\u08d0\3\2\2\2\u00bc"+
		"\u08d2\3\2\2\2\u00be\u08da\3\2\2\2\u00c0\u08e0\3\2\2\2\u00c2\u08e8\3\2"+
		"\2\2\u00c4\u08ef\3\2\2\2\u00c6\u08f4\3\2\2\2\u00c8\u08fd\3\2\2\2\u00ca"+
		"\u092b\3\2\2\2\u00cc\u093d\3\2\2\2\u00ce\u0946\3\2\2\2\u00d0\u0948\3\2"+
		"\2\2\u00d2\u095f\3\2\2\2\u00d4\u0965\3\2\2\2\u00d6\u0967\3\2\2\2\u00d8"+
		"\u0985\3\2\2\2\u00da\u0987\3\2\2\2\u00dc\u00df\5\f\7\2\u00dd\u00df\5\n"+
		"\6\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e6\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e3\u00e7\5\34\17\2\u00e4\u00e7\5\4\3\2\u00e5\u00e7\5\16\b\2\u00e6"+
		"\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\3\3\2\2\2"+
		"\u00e8\u00e9\5\6\4\2\u00e9\u00ea\5\b\5\2\u00ea\5\3\2\2\2\u00eb\u00ec\7"+
		"\u00f3\2\2\u00ec\u00ed\5\u00d2j\2\u00ed\u00ee\7Q\2\2\u00ee\u00f1\5\u00d2"+
		"j\2\u00ef\u00f0\7\u00ea\2\2\u00f0\u00f2\5\u00d2j\2\u00f1\u00ef\3\2\2\2"+
		"\u00f1\u00f2\3\2\2\2\u00f2\7\3\2\2\2\u00f3\u00f4\7\u00f4\2\2\u00f4\u00f7"+
		"\5\u00d2j\2\u00f5\u00f6\7Q\2\2\u00f6\u00f8\5\u00d2j\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00fa\7\u00ea\2\2\u00fa"+
		"\u00fc\5\u00d2j\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fd\u00fe\7\u00a2\2\2\u00fe\u00ff\5\u009aN\2\u00ff\t\3\2\2"+
		"\2\u0100\u0101\7\u00f2\2\2\u0101\u0102\5\u00d2j\2\u0102\u0103\7\u0080"+
		"\2\2\u0103\u0104\5\26\f\2\u0104\13\3\2\2\2\u0105\u0106\7\u00b3\2\2\u0106"+
		"\u0107\5\u00d2j\2\u0107\u010a\7\u0080\2\2\u0108\u010b\5\64\33\2\u0109"+
		"\u010b\5\4\3\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\r\3\2\2\2"+
		"\u010c\u010d\7\u00f0\2\2\u010d\u010e\5\20\t\2\u010e\17\3\2\2\2\u010f\u0114"+
		"\5\22\n\2\u0110\u0111\7\3\2\2\u0111\u0113\5\22\n\2\u0112\u0110\3\2\2\2"+
		"\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\7\3\2\2\u0118\u0119\7\u00f1\2"+
		"\2\u0119\u011a\7\4\2\2\u011a\u011b\5\u009aN\2\u011b\u011c\7\5\2\2\u011c"+
		"\21\3\2\2\2\u011d\u011f\5\u00d2j\2\u011e\u0120\5\24\13\2\u011f\u011e\3"+
		"\2\2\2\u011f\u0120\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u0122\7\u00ea\2\2"+
		"\u0122\u0124\5\u00d2j\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\23\3\2\2\2\u0125\u0126\7\4\2\2\u0126\u012a\7\5\2\2\u0127\u012a\5\u0082"+
		"B\2\u0128\u012a\5\u0084C\2\u0129\u0125\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u0128\3\2\2\2\u012a\25\3\2\2\2\u012b\u0133\7\u00f5\2\2\u012c\u0133\5"+
		"\u00d8m\2\u012d\u0133\5\30\r\2\u012e\u0133\7\u0100\2\2\u012f\u0133\7-"+
		"\2\2\u0130\u0133\7.\2\2\u0131\u0133\7,\2\2\u0132\u012b\3\2\2\2\u0132\u012c"+
		"\3\2\2\2\u0132\u012d\3\2\2\2\u0132\u012e\3\2\2\2\u0132\u012f\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0131\3\2\2\2\u0133\27\3\2\2\2\u0134\u0135\7\6\2"+
		"\2\u0135\u013a\5\32\16\2\u0136\u0137\7\7\2\2\u0137\u0139\5\32\16\2\u0138"+
		"\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\7\b\2\2\u013e"+
		"\u0142\3\2\2\2\u013f\u0140\7\6\2\2\u0140\u0142\7\b\2\2\u0141\u0134\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0142\31\3\2\2\2\u0143\u0144\7\u00f5\2\2\u0144"+
		"\u0145\7\t\2\2\u0145\u0146\5\26\f\2\u0146\33\3\2\2\2\u0147\u0149\7\u00b4"+
		"\2\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014c\3\2\2\2\u014a"+
		"\u014d\5\64\33\2\u014b\u014d\5\u00d2j\2\u014c\u014a\3\2\2\2\u014c\u014b"+
		"\3\2\2\2\u014d\35\3\2\2\2\u014e\u014f\5(\25\2\u014f\u0150\7\2\2\3\u0150"+
		"\37\3\2\2\2\u0151\u0152\5\u0098M\2\u0152\u0153\7\2\2\3\u0153!\3\2\2\2"+
		"\u0154\u0155\5\u0094K\2\u0155\u0156\7\2\2\3\u0156#\3\2\2\2\u0157\u0158"+
		"\5\u0096L\2\u0158\u0159\7\2\2\3\u0159%\3\2\2\2\u015a\u015b\5\u00ba^\2"+
		"\u015b\u015c\7\2\2\3\u015c\'\3\2\2\2\u015d\u03bc\5\64\33\2\u015e\u015f"+
		"\7e\2\2\u015f\u03bc\5\u00d2j\2\u0160\u0161\7S\2\2\u0161\u0165\7\u00cd"+
		"\2\2\u0162\u0163\7\177\2\2\u0163\u0164\7%\2\2\u0164\u0166\7\'\2\2\u0165"+
		"\u0162\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016a\5\u00d2"+
		"j\2\u0168\u0169\7u\2\2\u0169\u016b\7\u00f5\2\2\u016a\u0168\3\2\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016e\5\62\32\2\u016d\u016c\3"+
		"\2\2\2\u016d\u016e\3\2\2\2\u016e\u0172\3\2\2\2\u016f\u0170\7Q\2\2\u0170"+
		"\u0171\7\u00b8\2\2\u0171\u0173\5H%\2\u0172\u016f\3\2\2\2\u0172\u0173\3"+
		"\2\2\2\u0173\u03bc\3\2\2\2\u0174\u0175\7p\2\2\u0175\u0176\7\u00cd\2\2"+
		"\u0176\u0177\5\u00d2j\2\u0177\u0178\7v\2\2\u0178\u0179\7\u00b8\2\2\u0179"+
		"\u017a\5H%\2\u017a\u03bc\3\2\2\2\u017b\u017c\7h\2\2\u017c\u017f\7\u00cd"+
		"\2\2\u017d\u017e\7\177\2\2\u017e\u0180\7\'\2\2\u017f\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\5\u00d2j\2\u0182\u0184"+
		"\t\2\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u03bc\3\2\2\2\u0185"+
		"\u018a\5,\27\2\u0186\u0187\7\4\2\2\u0187\u0188\5\u00bc_\2\u0188\u0189"+
		"\7\5\2\2\u0189\u018b\3\2\2\2\u018a\u0186\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018f\5F$\2\u018d\u018e\7\u00b5\2\2\u018e\u0190\5"+
		"H%\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0194\3\2\2\2\u0191"+
		"\u0192\7\u00d5\2\2\u0192\u0193\7\31\2\2\u0193\u0195\5\u0082B\2\u0194\u0191"+
		"\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196\u0198\5.\30\2\u0197"+
		"\u0196\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u019b\5\62"+
		"\32\2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019e\3\2\2\2\u019c"+
		"\u019d\7u\2\2\u019d\u019f\7\u00f5\2\2\u019e\u019c\3\2\2\2\u019e\u019f"+
		"\3\2\2\2\u019f\u01a4\3\2\2\2\u01a0\u01a2\7\24\2\2\u01a1\u01a0\3\2\2\2"+
		"\u01a1\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a5\5\64\33\2\u01a4\u01a1"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u03bc\3\2\2\2\u01a6\u01ab\5,\27\2\u01a7"+
		"\u01a8\7\4\2\2\u01a8\u01a9\5\u00bc_\2\u01a9\u01aa\7\5\2\2\u01aa\u01ac"+
		"\3\2\2\2\u01ab\u01a7\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad"+
		"\u01ae\7u\2\2\u01ae\u01b0\7\u00f5\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0"+
		"\3\2\2\2\u01b0\u01b7\3\2\2\2\u01b1\u01b2\7\u00d5\2\2\u01b2\u01b3\7\31"+
		"\2\2\u01b3\u01b4\7\4\2\2\u01b4\u01b5\5\u00bc_\2\u01b5\u01b6\7\5\2\2\u01b6"+
		"\u01b8\3\2\2\2\u01b7\u01b1\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2"+
		"\2\2\u01b9\u01bb\5.\30\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bd\3\2\2\2\u01bc\u01be\5\60\31\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3"+
		"\2\2\2\u01be\u01c0\3\2\2\2\u01bf\u01c1\5\u0092J\2\u01c0\u01bf\3\2\2\2"+
		"\u01c0\u01c1\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c4\5T+\2\u01c3\u01c2"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01c7\5\62\32\2"+
		"\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c9"+
		"\7\u00b7\2\2\u01c9\u01cb\5H%\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2"+
		"\u01cb\u01d0\3\2\2\2\u01cc\u01ce\7\24\2\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce"+
		"\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\5\64\33\2\u01d0\u01cd\3\2\2\2"+
		"\u01d0\u01d1\3\2\2\2\u01d1\u03bc\3\2\2\2\u01d2\u01d3\7S\2\2\u01d3\u01d7"+
		"\7T\2\2\u01d4\u01d5\7\177\2\2\u01d5\u01d6\7%\2\2\u01d6\u01d8\7\'\2\2\u01d7"+
		"\u01d4\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\5\u0094"+
		"K\2\u01da\u01db\7)\2\2\u01db\u01dd\5\u0094K\2\u01dc\u01de\5\62\32\2\u01dd"+
		"\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u03bc\3\2\2\2\u01df\u01e0\7\u00d1"+
		"\2\2\u01e0\u01e1\7T\2\2\u01e1\u01e3\5\u0094K\2\u01e2\u01e4\5:\36\2\u01e3"+
		"\u01e2\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\7\u00d2"+
		"\2\2\u01e6\u01eb\7\u00d4\2\2\u01e7\u01ec\5\u00d2j\2\u01e8\u01e9\7\62\2"+
		"\2\u01e9\u01ea\7c\2\2\u01ea\u01ec\5\u0084C\2\u01eb\u01e7\3\2\2\2\u01eb"+
		"\u01e8\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u03bc\3\2\2\2\u01ed\u01ee\7p"+
		"\2\2\u01ee\u01ef\7T\2\2\u01ef\u01f0\5\u0094K\2\u01f0\u01f1\7\23\2\2\u01f1"+
		"\u01f2\7c\2\2\u01f2\u01f3\7\4\2\2\u01f3\u01f4\5\u00bc_\2\u01f4\u01f5\7"+
		"\5\2\2\u01f5\u03bc\3\2\2\2\u01f6\u01f7\7p\2\2\u01f7\u01f8\t\3\2\2\u01f8"+
		"\u01f9\5\u0094K\2\u01f9\u01fa\7q\2\2\u01fa\u01fb\7m\2\2\u01fb\u01fc\5"+
		"\u0094K\2\u01fc\u03bc\3\2\2\2\u01fd\u01fe\7p\2\2\u01fe\u01ff\t\3\2\2\u01ff"+
		"\u0200\5\u0094K\2\u0200\u0201\7v\2\2\u0201\u0202\7\u00b7\2\2\u0202\u0203"+
		"\5H%\2\u0203\u03bc\3\2\2\2\u0204\u0205\7p\2\2\u0205\u0206\t\3\2\2\u0206"+
		"\u0207\5\u0094K\2\u0207\u0208\7\u00b6\2\2\u0208\u020b\7\u00b7\2\2\u0209"+
		"\u020a\7\177\2\2\u020a\u020c\7\'\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3"+
		"\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\5H%\2\u020e\u03bc\3\2\2\2\u020f"+
		"\u0210\7p\2\2\u0210\u0211\7T\2\2\u0211\u0213\5\u0094K\2\u0212\u0214\5"+
		":\36\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u0217\7\u00c5\2\2\u0216\u0218\7d\2\2\u0217\u0216\3\2\2\2\u0217\u0218"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\5\u00d2j\2\u021a\u021c\5\u00be"+
		"`\2\u021b\u021d\5\u00b8]\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d"+
		"\u03bc\3\2\2\2\u021e\u021f\7p\2\2\u021f\u0220\7T\2\2\u0220\u0222\5\u0094"+
		"K\2\u0221\u0223\5:\36\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0225\7v\2\2\u0225\u0226\7\u009d\2\2\u0226\u022a"+
		"\7\u00f5\2\2\u0227\u0228\7Q\2\2\u0228\u0229\7\u009e\2\2\u0229\u022b\5"+
		"H%\2\u022a\u0227\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u03bc\3\2\2\2\u022c"+
		"\u022d\7p\2\2\u022d\u022e\7T\2\2\u022e\u0230\5\u0094K\2\u022f\u0231\5"+
		":\36\2\u0230\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232\3\2\2\2\u0232"+
		"\u0233\7v\2\2\u0233\u0234\7\u009e\2\2\u0234\u0235\5H%\2\u0235\u03bc\3"+
		"\2\2\2\u0236\u0237\7p\2\2\u0237\u0238\7T\2\2\u0238\u0239\5\u0094K\2\u0239"+
		"\u023d\7\23\2\2\u023a\u023b\7\177\2\2\u023b\u023c\7%\2\2\u023c\u023e\7"+
		"\'\2\2\u023d\u023a\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2\2\u023f"+
		"\u0241\58\35\2\u0240\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0240\3\2"+
		"\2\2\u0242\u0243\3\2\2\2\u0243\u03bc\3\2\2\2\u0244\u0245\7p\2\2\u0245"+
		"\u0246\7U\2\2\u0246\u0247\5\u0094K\2\u0247\u024b\7\23\2\2\u0248\u0249"+
		"\7\177\2\2\u0249\u024a\7%\2\2\u024a\u024c\7\'\2\2\u024b\u0248\3\2\2\2"+
		"\u024b\u024c\3\2\2\2\u024c\u024e\3\2\2\2\u024d\u024f\5:\36\2\u024e\u024d"+
		"\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"\u03bc\3\2\2\2\u0252\u0253\7p\2\2\u0253\u0254\7T\2\2\u0254\u0255\5\u0094"+
		"K\2\u0255\u0256\5:\36\2\u0256\u0257\7q\2\2\u0257\u0258\7m\2\2\u0258\u0259"+
		"\5:\36\2\u0259\u03bc\3\2\2\2\u025a\u025b\7p\2\2\u025b\u025c\7T\2\2\u025c"+
		"\u025d\5\u0094K\2\u025d\u0260\7h\2\2\u025e\u025f\7\177\2\2\u025f\u0261"+
		"\7\'\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u0267\5:\36\2\u0263\u0264\7\7\2\2\u0264\u0266\5:\36\2\u0265\u0263\3\2"+
		"\2\2\u0266\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268"+
		"\u026b\3\2\2\2\u0269\u0267\3\2\2\2\u026a\u026c\7\u00ca\2\2\u026b\u026a"+
		"\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u03bc\3\2\2\2\u026d\u026e\7p\2\2\u026e"+
		"\u026f\7U\2\2\u026f\u0270\5\u0094K\2\u0270\u0273\7h\2\2\u0271\u0272\7"+
		"\177\2\2\u0272\u0274\7\'\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"\u0275\3\2\2\2\u0275\u027a\5:\36\2\u0276\u0277\7\7\2\2\u0277\u0279\5:"+
		"\36\2\u0278\u0276\3\2\2\2\u0279\u027c\3\2\2\2\u027a\u0278\3\2\2\2\u027a"+
		"\u027b\3\2\2\2\u027b\u03bc\3\2\2\2\u027c\u027a\3\2\2\2\u027d\u027e\7p"+
		"\2\2\u027e\u027f\7T\2\2\u027f\u0281\5\u0094K\2\u0280\u0282\5:\36\2\u0281"+
		"\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0284\7v"+
		"\2\2\u0284\u0285\5\62\32\2\u0285\u03bc\3\2\2\2\u0286\u0287\7p\2\2\u0287"+
		"\u0288\7T\2\2\u0288\u0289\5\u0094K\2\u0289\u028a\7\u00de\2\2\u028a\u028b"+
		"\7f\2\2\u028b\u03bc\3\2\2\2\u028c\u028d\7h\2\2\u028d\u0290\7T\2\2\u028e"+
		"\u028f\7\177\2\2\u028f\u0291\7\'\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3"+
		"\2\2\2\u0291\u0292\3\2\2\2\u0292\u0294\5\u0094K\2\u0293\u0295\7\u00ca"+
		"\2\2\u0294\u0293\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u03bc\3\2\2\2\u0296"+
		"\u0297\7h\2\2\u0297\u029a\7U\2\2\u0298\u0299\7\177\2\2\u0299\u029b\7\'"+
		"\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c"+
		"\u03bc\5\u0094K\2\u029d\u02a0\7S\2\2\u029e\u029f\7\"\2\2\u029f\u02a1\7"+
		"V\2\2\u02a0\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a6\3\2\2\2\u02a2"+
		"\u02a4\7\u00b2\2\2\u02a3\u02a2\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a5"+
		"\3\2\2\2\u02a5\u02a7\7\u00b3\2\2\u02a6\u02a3\3\2\2\2\u02a6\u02a7\3\2\2"+
		"\2\u02a7\u02a8\3\2\2\2\u02a8\u02ac\7U\2\2\u02a9\u02aa\7\177\2\2\u02aa"+
		"\u02ab\7%\2\2\u02ab\u02ad\7\'\2\2\u02ac\u02a9\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02b0\5\u0094K\2\u02af\u02b1\5\u008aF\2"+
		"\u02b0\u02af\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b3"+
		"\7u\2\2\u02b3\u02b5\7\u00f5\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5\3\2\2"+
		"\2\u02b5\u02b9\3\2\2\2\u02b6\u02b7\7\u00d5\2\2\u02b7\u02b8\7B\2\2\u02b8"+
		"\u02ba\5\u0082B\2\u02b9\u02b6\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bd"+
		"\3\2\2\2\u02bb\u02bc\7\u00b7\2\2\u02bc\u02be\5H%\2\u02bd\u02bb\3\2\2\2"+
		"\u02bd\u02be\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c0\7\24\2\2\u02c0\u02c1"+
		"\5\64\33\2\u02c1\u03bc\3\2\2\2\u02c2\u02c5\7S\2\2\u02c3\u02c4\7\"\2\2"+
		"\u02c4\u02c6\7V\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c8"+
		"\3\2\2\2\u02c7\u02c9\7\u00b2\2\2\u02c8\u02c7\3\2\2\2\u02c8\u02c9\3\2\2"+
		"\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\7\u00b3\2\2\u02cb\u02cc\7U\2\2\u02cc"+
		"\u02d1\5\u0094K\2\u02cd\u02ce\7\4\2\2\u02ce\u02cf\5\u00bc_\2\u02cf\u02d0"+
		"\7\5\2\2\u02d0\u02d2\3\2\2\2\u02d1\u02cd\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2"+
		"\u02d3\3\2\2\2\u02d3\u02d6\5F$\2\u02d4\u02d5\7\u00b5\2\2\u02d5\u02d7\5"+
		"H%\2\u02d6\u02d4\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u03bc\3\2\2\2\u02d8"+
		"\u02d9\7p\2\2\u02d9\u02da\7U\2\2\u02da\u02dc\5\u0094K\2\u02db\u02dd\7"+
		"\24\2\2\u02dc\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\3\2\2\2\u02de"+
		"\u02df\5\64\33\2\u02df\u03bc\3\2\2\2\u02e0\u02e2\7S\2\2\u02e1\u02e3\7"+
		"\u00b3\2\2\u02e2\u02e1\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e4\3\2\2\2"+
		"\u02e4\u02e5\7\u00aa\2\2\u02e5\u02e6\5\u00d0i\2\u02e6\u02e7\7\24\2\2\u02e7"+
		"\u02f1\7\u00f5\2\2\u02e8\u02e9\7\u009c\2\2\u02e9\u02ee\5Z.\2\u02ea\u02eb"+
		"\7\7\2\2\u02eb\u02ed\5Z.\2\u02ec\u02ea\3\2\2\2\u02ed\u02f0\3\2\2\2\u02ee"+
		"\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0\u02ee\3\2"+
		"\2\2\u02f1\u02e8\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u03bc\3\2\2\2\u02f3"+
		"\u02f5\7h\2\2\u02f4\u02f6\7\u00b3\2\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6"+
		"\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02fa\7\u00aa\2\2\u02f8\u02f9\7\177"+
		"\2\2\u02f9\u02fb\7\'\2\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb"+
		"\u02fc\3\2\2\2\u02fc\u03bc\5\u00d0i\2\u02fd\u02ff\7[\2\2\u02fe\u0300\t"+
		"\4\2\2\u02ff\u02fe\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0301\3\2\2\2\u0301"+
		"\u03bc\5(\25\2\u0302\u0303\7a\2\2\u0303\u0306\7b\2\2\u0304\u0305\t\5\2"+
		"\2\u0305\u0307\5\u00d2j\2\u0306\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307"+
		"\u030c\3\2\2\2\u0308\u030a\7)\2\2\u0309\u0308\3\2\2\2\u0309\u030a\3\2"+
		"\2\2\u030a\u030b\3\2\2\2\u030b\u030d\7\u00f5\2\2\u030c\u0309\3\2\2\2\u030c"+
		"\u030d\3\2\2\2\u030d\u03bc\3\2\2\2\u030e\u030f\7a\2\2\u030f\u0310\7T\2"+
		"\2\u0310\u0313\7\u00ab\2\2\u0311\u0312\t\5\2\2\u0312\u0314\5\u00d2j\2"+
		"\u0313\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316"+
		"\7)\2\2\u0316\u0318\7\u00f5\2\2\u0317\u0319\5:\36\2\u0318\u0317\3\2\2"+
		"\2\u0318\u0319\3\2\2\2\u0319\u03bc\3\2\2\2\u031a\u031b\7a\2\2\u031b\u031e"+
		"\7\u00ce\2\2\u031c\u031d\7)\2\2\u031d\u031f\7\u00f5\2\2\u031e\u031c\3"+
		"\2\2\2\u031e\u031f\3\2\2\2\u031f\u03bc\3\2\2\2\u0320\u0321\7a\2\2\u0321"+
		"\u0322\7\u00b7\2\2\u0322\u0327\5\u0094K\2\u0323\u0324\7\4\2\2\u0324\u0325"+
		"\5L\'\2\u0325\u0326\7\5\2\2\u0326\u0328\3\2\2\2\u0327\u0323\3\2\2\2\u0327"+
		"\u0328\3\2\2\2\u0328\u03bc\3\2\2\2\u0329\u032a\7a\2\2\u032a\u032b\7c\2"+
		"\2\u032b\u032c\t\5\2\2\u032c\u032f\5\u0094K\2\u032d\u032e\t\5\2\2\u032e"+
		"\u0330\5\u00d2j\2\u032f\u032d\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u03bc"+
		"\3\2\2\2\u0331\u0332\7a\2\2\u0332\u0333\7f\2\2\u0333\u0335\5\u0094K\2"+
		"\u0334\u0336\5:\36\2\u0335\u0334\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u03bc"+
		"\3\2\2\2\u0337\u0339\7a\2\2\u0338\u033a\5\u00d2j\2\u0339\u0338\3\2\2\2"+
		"\u0339\u033a\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u0343\7g\2\2\u033c\u033e"+
		"\7)\2\2\u033d\u033c\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u0341\3\2\2\2\u033f"+
		"\u0342\5\u00d0i\2\u0340\u0342\7\u00f5\2\2\u0341\u033f\3\2\2\2\u0341\u0340"+
		"\3\2\2\2\u0342\u0344\3\2\2\2\u0343\u033d\3\2\2\2\u0343\u0344\3\2\2\2\u0344"+
		"\u03bc\3\2\2\2\u0345\u0346\7a\2\2\u0346\u0347\7S\2\2\u0347\u0348\7T\2"+
		"\2\u0348\u03bc\5\u0094K\2\u0349\u034a\t\6\2\2\u034a\u034c\7\u00aa\2\2"+
		"\u034b\u034d\7\u00ab\2\2\u034c\u034b\3\2\2\2\u034c\u034d\3\2\2\2\u034d"+
		"\u034e\3\2\2\2\u034e\u03bc\5> \2\u034f\u0350\t\6\2\2\u0350\u0352\7\u00cd"+
		"\2\2\u0351\u0353\7\u00ab\2\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2\2\2\u0353"+
		"\u0354\3\2\2\2\u0354\u03bc\5\u00d2j\2\u0355\u0357\t\6\2\2\u0356\u0358"+
		"\7T\2\2\u0357\u0356\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a\3\2\2\2\u0359"+
		"\u035b\t\7\2\2\u035a\u0359\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035c\3\2"+
		"\2\2\u035c\u035e\5\u0094K\2\u035d\u035f\5:\36\2\u035e\u035d\3\2\2\2\u035e"+
		"\u035f\3\2\2\2\u035f\u0361\3\2\2\2\u0360\u0362\5@!\2\u0361\u0360\3\2\2"+
		"\2\u0361\u0362\3\2\2\2\u0362\u03bc\3\2\2\2\u0363\u0364\7\u00ac\2\2\u0364"+
		"\u0365\7T\2\2\u0365\u03bc\5\u0094K\2\u0366\u036a\7\u00ac\2\2\u0367\u0369"+
		"\13\2\2\2\u0368\u0367\3\2\2\2\u0369\u036c\3\2\2\2\u036a\u036b\3\2\2\2"+
		"\u036a\u0368\3\2\2\2\u036b\u03bc\3\2\2\2\u036c\u036a\3\2\2\2\u036d\u036f"+
		"\7\u00ae\2\2\u036e\u0370\7\u00b0\2\2\u036f\u036e\3\2\2\2\u036f\u0370\3"+
		"\2\2\2\u0370\u0371\3\2\2\2\u0371\u0372\7T\2\2\u0372\u0377\5\u0094K\2\u0373"+
		"\u0375\7\24\2\2\u0374\u0373\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0376\3"+
		"\2\2\2\u0376\u0378\5\64\33\2\u0377\u0374\3\2\2\2\u0377\u0378\3\2\2\2\u0378"+
		"\u03bc\3\2\2\2\u0379\u037a\7\u00af\2\2\u037a\u037d\7T\2\2\u037b\u037c"+
		"\7\177\2\2\u037c\u037e\7\'\2\2\u037d\u037b\3\2\2\2\u037d\u037e\3\2\2\2"+
		"\u037e\u037f\3\2\2\2\u037f\u03bc\5\u0094K\2\u0380\u0381\7\u00ad\2\2\u0381"+
		"\u03bc\7\u00ae\2\2\u0382\u0383\7\u00e1\2\2\u0383\u0385\7x\2\2\u0384\u0386"+
		"\7\u00ec\2\2\u0385\u0384\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0387\3\2\2"+
		"\2\u0387\u0388\7\u00ed\2\2\u0388\u038a\7\u00f5\2\2\u0389\u038b\7\u0099"+
		"\2\2\u038a\u0389\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u038c\3\2\2\2\u038c"+
		"\u038d\7Y\2\2\u038d\u038e\7T\2\2\u038e\u0390\5\u0094K\2\u038f\u0391\5"+
		":\36\2\u0390\u038f\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u03bc\3\2\2\2\u0392"+
		"\u0393\7\u00d0\2\2\u0393\u0394\7T\2\2\u0394\u0396\5\u0094K\2\u0395\u0397"+
		"\5:\36\2\u0396\u0395\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u03bc\3\2\2\2\u0398"+
		"\u0399\7\u00dc\2\2\u0399\u039a\7\u00dd\2\2\u039a\u039b\7T\2\2\u039b\u03bc"+
		"\5\u0094K\2\u039c\u039d\t\b\2\2\u039d\u03a1\5\u00d2j\2\u039e\u03a0\13"+
		"\2\2\2\u039f\u039e\3\2\2\2\u03a0\u03a3\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a1"+
		"\u039f\3\2\2\2\u03a2\u03bc\3\2\2\2\u03a3\u03a1\3\2\2\2\u03a4\u03a5\7v"+
		"\2\2\u03a5\u03a9\7\u00e2\2\2\u03a6\u03a8\13\2\2\2\u03a7\u03a6\3\2\2\2"+
		"\u03a8\u03ab\3\2\2\2\u03a9\u03aa\3\2\2\2\u03a9\u03a7\3\2\2\2\u03aa\u03bc"+
		"\3\2\2\2\u03ab\u03a9\3\2\2\2\u03ac\u03b0\7v\2\2\u03ad\u03af\13\2\2\2\u03ae"+
		"\u03ad\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b0\u03ae\3\2"+
		"\2\2\u03b1\u03bc\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b3\u03bc\7w\2\2\u03b4"+
		"\u03b8\5*\26\2\u03b5\u03b7\13\2\2\2\u03b6\u03b5\3\2\2\2\u03b7\u03ba\3"+
		"\2\2\2\u03b8\u03b9\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b9\u03bc\3\2\2\2\u03ba"+
		"\u03b8\3\2\2\2\u03bb\u015d\3\2\2\2\u03bb\u015e\3\2\2\2\u03bb\u0160\3\2"+
		"\2\2\u03bb\u0174\3\2\2\2\u03bb\u017b\3\2\2\2\u03bb\u0185\3\2\2\2\u03bb"+
		"\u01a6\3\2\2\2\u03bb\u01d2\3\2\2\2\u03bb\u01df\3\2\2\2\u03bb\u01ed\3\2"+
		"\2\2\u03bb\u01f6\3\2\2\2\u03bb\u01fd\3\2\2\2\u03bb\u0204\3\2\2\2\u03bb"+
		"\u020f\3\2\2\2\u03bb\u021e\3\2\2\2\u03bb\u022c\3\2\2\2\u03bb\u0236\3\2"+
		"\2\2\u03bb\u0244\3\2\2\2\u03bb\u0252\3\2\2\2\u03bb\u025a\3\2\2\2\u03bb"+
		"\u026d\3\2\2\2\u03bb\u027d\3\2\2\2\u03bb\u0286\3\2\2\2\u03bb\u028c\3\2"+
		"\2\2\u03bb\u0296\3\2\2\2\u03bb\u029d\3\2\2\2\u03bb\u02c2\3\2\2\2\u03bb"+
		"\u02d8\3\2\2\2\u03bb\u02e0\3\2\2\2\u03bb\u02f3\3\2\2\2\u03bb\u02fd\3\2"+
		"\2\2\u03bb\u0302\3\2\2\2\u03bb\u030e\3\2\2\2\u03bb\u031a\3\2\2\2\u03bb"+
		"\u0320\3\2\2\2\u03bb\u0329\3\2\2\2\u03bb\u0331\3\2\2\2\u03bb\u0337\3\2"+
		"\2\2\u03bb\u0345\3\2\2\2\u03bb\u0349\3\2\2\2\u03bb\u034f\3\2\2\2\u03bb"+
		"\u0355\3\2\2\2\u03bb\u0363\3\2\2\2\u03bb\u0366\3\2\2\2\u03bb\u036d\3\2"+
		"\2\2\u03bb\u0379\3\2\2\2\u03bb\u0380\3\2\2\2\u03bb\u0382\3\2\2\2\u03bb"+
		"\u0392\3\2\2\2\u03bb\u0398\3\2\2\2\u03bb\u039c\3\2\2\2\u03bb\u03a4\3\2"+
		"\2\2\u03bb\u03ac\3\2\2\2\u03bb\u03b3\3\2\2\2\u03bb\u03b4\3\2\2\2\u03bc"+
		")\3\2\2\2\u03bd\u03be\7S\2\2\u03be\u0468\7\u00e2\2\2\u03bf\u03c0\7h\2"+
		"\2\u03c0\u0468\7\u00e2\2\2\u03c1\u03c3\7\u00d9\2\2\u03c2\u03c4\7\u00e2"+
		"\2\2\u03c3\u03c2\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u0468\3\2\2\2\u03c5"+
		"\u03c7\7\u00d8\2\2\u03c6\u03c8\7\u00e2\2\2\u03c7\u03c6\3\2\2\2\u03c7\u03c8"+
		"\3\2\2\2\u03c8\u0468\3\2\2\2\u03c9\u03ca\7a\2\2\u03ca\u0468\7\u00d9\2"+
		"\2\u03cb\u03cc\7a\2\2\u03cc\u03ce\7\u00e2\2\2\u03cd\u03cf\7\u00d9\2\2"+
		"\u03ce\u03cd\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u0468\3\2\2\2\u03d0\u03d1"+
		"\7a\2\2\u03d1\u0468\7\u00e5\2\2\u03d2\u03d3\7a\2\2\u03d3\u0468\7\u00e3"+
		"\2\2\u03d4\u03d5\7a\2\2\u03d5\u03d6\7L\2\2\u03d6\u0468\7\u00e3\2\2\u03d7"+
		"\u03d8\7\u00df\2\2\u03d8\u0468\7T\2\2\u03d9\u03da\7\u00e0\2\2\u03da\u0468"+
		"\7T\2\2\u03db\u03dc\7a\2\2\u03dc\u0468\7\u00e4\2\2\u03dd\u03de\7a\2\2"+
		"\u03de\u03df\7S\2\2\u03df\u0468\7T\2\2\u03e0\u03e1\7a\2\2\u03e1\u0468"+
		"\7\u00e6\2\2\u03e2\u03e3\7a\2\2\u03e3\u0468\7\u00e8\2\2\u03e4\u03e5\7"+
		"a\2\2\u03e5\u0468\7\u00e9\2\2\u03e6\u03e7\7S\2\2\u03e7\u0468\7\u00e7\2"+
		"\2\u03e8\u03e9\7h\2\2\u03e9\u0468\7\u00e7\2\2\u03ea\u03eb\7p\2\2\u03eb"+
		"\u0468\7\u00e7\2\2\u03ec\u03ed\7\u00da\2\2\u03ed\u0468\7T\2\2\u03ee\u03ef"+
		"\7\u00da\2\2\u03ef\u0468\7\u00cd\2\2\u03f0\u03f1\7\u00db\2\2\u03f1\u0468"+
		"\7T\2\2\u03f2\u03f3\7\u00db\2\2\u03f3\u0468\7\u00cd\2\2\u03f4\u03f5\7"+
		"S\2\2\u03f5\u03f6\7\u00b3\2\2\u03f6\u0468\7}\2\2\u03f7\u03f8\7h\2\2\u03f8"+
		"\u03f9\7\u00b3\2\2\u03f9\u0468\7}\2\2\u03fa\u03fb\7p\2\2\u03fb\u03fc\7"+
		"T\2\2\u03fc\u03fd\5\u0094K\2\u03fd\u03fe\7%\2\2\u03fe\u03ff\7\u00c8\2"+
		"\2\u03ff\u0468\3\2\2\2\u0400\u0401\7p\2\2\u0401\u0402\7T\2\2\u0402\u0403"+
		"\5\u0094K\2\u0403\u0404\7\u00c8\2\2\u0404\u0405\7\31\2\2\u0405\u0468\3"+
		"\2\2\2\u0406\u0407\7p\2\2\u0407\u0408\7T\2\2\u0408\u0409\5\u0094K\2\u0409"+
		"\u040a\7%\2\2\u040a\u040b\7\u00c9\2\2\u040b\u0468\3\2\2\2\u040c\u040d"+
		"\7p\2\2\u040d\u040e\7T\2\2\u040e\u040f\5\u0094K\2\u040f\u0410\7\u00ba"+
		"\2\2\u0410\u0411\7\31\2\2\u0411\u0468\3\2\2\2\u0412\u0413\7p\2\2\u0413"+
		"\u0414\7T\2\2\u0414\u0415\5\u0094K\2\u0415\u0416\7%\2\2\u0416\u0417\7"+
		"\u00ba\2\2\u0417\u0468\3\2\2\2\u0418\u0419\7p\2\2\u0419\u041a\7T\2\2\u041a"+
		"\u041b\5\u0094K\2\u041b\u041c\7%\2\2\u041c\u041d\7\u00bb\2\2\u041d\u041e"+
		"\7\24\2\2\u041e\u041f\7\u00bc\2\2\u041f\u0468\3\2\2\2\u0420\u0421\7p\2"+
		"\2\u0421\u0422\7T\2\2\u0422\u0423\5\u0094K\2\u0423\u0424\7v\2\2\u0424"+
		"\u0425\7\u00ba\2\2\u0425\u0426\7\u00bd\2\2\u0426\u0468\3\2\2\2\u0427\u0428"+
		"\7p\2\2\u0428\u0429\7T\2\2\u0429\u042a\5\u0094K\2\u042a\u042b\7\u00be"+
		"\2\2\u042b\u042c\7F\2\2\u042c\u0468\3\2\2\2\u042d\u042e\7p\2\2\u042e\u042f"+
		"\7T\2\2\u042f\u0430\5\u0094K\2\u0430\u0431\7\u00bf\2\2\u0431\u0432\7F"+
		"\2\2\u0432\u0468\3\2\2\2\u0433\u0434\7p\2\2\u0434\u0435\7T\2\2\u0435\u0436"+
		"\5\u0094K\2\u0436\u0437\7\u00c0\2\2\u0437\u0438\7F\2\2\u0438\u0468\3\2"+
		"\2\2\u0439\u043a\7p\2\2\u043a\u043b\7T\2\2\u043b\u043c\5\u0094K\2\u043c"+
		"\u043d\7\u00c2\2\2\u043d\u0468\3\2\2\2\u043e\u043f\7p\2\2\u043f\u0440"+
		"\7T\2\2\u0440\u0442\5\u0094K\2\u0441\u0443\5:\36\2\u0442\u0441\3\2\2\2"+
		"\u0442\u0443\3\2\2\2\u0443\u0444\3\2\2\2\u0444\u0445\7\u00c3\2\2\u0445"+
		"\u0468\3\2\2\2\u0446\u0447\7p\2\2\u0447\u0448\7T\2\2\u0448\u044a\5\u0094"+
		"K\2\u0449\u044b\5:\36\2\u044a\u0449\3\2\2\2\u044a\u044b\3\2\2\2\u044b"+
		"\u044c\3\2\2\2\u044c\u044d\7\u00c4\2\2\u044d\u0468\3\2\2\2\u044e\u044f"+
		"\7p\2\2\u044f\u0450\7T\2\2\u0450\u0452\5\u0094K\2\u0451\u0453\5:\36\2"+
		"\u0452\u0451\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0455"+
		"\7v\2\2\u0455\u0456\7\u00c1\2\2\u0456\u0468\3\2\2\2\u0457\u0458\7p\2\2"+
		"\u0458\u0459\7T\2\2\u0459\u045b\5\u0094K\2\u045a\u045c\5:\36\2\u045b\u045a"+
		"\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045d\3\2\2\2\u045d\u045e\7V\2\2\u045e"+
		"\u045f\7c\2\2\u045f\u0468\3\2\2\2\u0460\u0461\7y\2\2\u0461\u0468\7z\2"+
		"\2\u0462\u0468\7{\2\2\u0463\u0468\7|\2\2\u0464\u0468\7\u00cf\2\2\u0465"+
		"\u0466\7X\2\2\u0466\u0468\7\22\2\2\u0467\u03bd\3\2\2\2\u0467\u03bf\3\2"+
		"\2\2\u0467\u03c1\3\2\2\2\u0467\u03c5\3\2\2\2\u0467\u03c9\3\2\2\2\u0467"+
		"\u03cb\3\2\2\2\u0467\u03d0\3\2\2\2\u0467\u03d2\3\2\2\2\u0467\u03d4\3\2"+
		"\2\2\u0467\u03d7\3\2\2\2\u0467\u03d9\3\2\2\2\u0467\u03db\3\2\2\2\u0467"+
		"\u03dd\3\2\2\2\u0467\u03e0\3\2\2\2\u0467\u03e2\3\2\2\2\u0467\u03e4\3\2"+
		"\2\2\u0467\u03e6\3\2\2\2\u0467\u03e8\3\2\2\2\u0467\u03ea\3\2\2\2\u0467"+
		"\u03ec\3\2\2\2\u0467\u03ee\3\2\2\2\u0467\u03f0\3\2\2\2\u0467\u03f2\3\2"+
		"\2\2\u0467\u03f4\3\2\2\2\u0467\u03f7\3\2\2\2\u0467\u03fa\3\2\2\2\u0467"+
		"\u0400\3\2\2\2\u0467\u0406\3\2\2\2\u0467\u040c\3\2\2\2\u0467\u0412\3\2"+
		"\2\2\u0467\u0418\3\2\2\2\u0467\u0420\3\2\2\2\u0467\u0427\3\2\2\2\u0467"+
		"\u042d\3\2\2\2\u0467\u0433\3\2\2\2\u0467\u0439\3\2\2\2\u0467\u043e\3\2"+
		"\2\2\u0467\u0446\3\2\2\2\u0467\u044e\3\2\2\2\u0467\u0457\3\2\2\2\u0467"+
		"\u0460\3\2\2\2\u0467\u0462\3\2\2\2\u0467\u0463\3\2\2\2\u0467\u0464\3\2"+
		"\2\2\u0467\u0465\3\2\2\2\u0468+\3\2\2\2\u0469\u046b\7S\2\2\u046a\u046c"+
		"\7\u00b3\2\2\u046b\u046a\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046e\3\2\2"+
		"\2\u046d\u046f\7\u00d6\2\2\u046e\u046d\3\2\2\2\u046e\u046f\3\2\2\2\u046f"+
		"\u0470\3\2\2\2\u0470\u0474\7T\2\2\u0471\u0472\7\177\2\2\u0472\u0473\7"+
		"%\2\2\u0473\u0475\7\'\2\2\u0474\u0471\3\2\2\2\u0474\u0475\3\2\2\2\u0475"+
		"\u0476\3\2\2\2\u0476\u0477\5\u0094K\2\u0477-\3\2\2\2\u0478\u0479\7\u00c8"+
		"\2\2\u0479\u047a\7\31\2\2\u047a\u047e\5\u0082B\2\u047b\u047c\7\u00c9\2"+
		"\2\u047c\u047d\7\31\2\2\u047d\u047f\5\u0086D\2\u047e\u047b\3\2\2\2\u047e"+
		"\u047f\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0481\7Y\2\2\u0481\u0482\7\u00fa"+
		"\2\2\u0482\u0483\7\u00b9\2\2\u0483/\3\2\2\2\u0484\u0485\7\u00ba\2\2\u0485"+
		"\u0486\7\31\2\2\u0486\u0487\5\u0082B\2\u0487\u048a\7B\2\2\u0488\u048b"+
		"\5P)\2\u0489\u048b\5R*\2\u048a\u0488\3\2\2\2\u048a\u0489\3\2\2\2\u048b"+
		"\u048f\3\2\2\2\u048c\u048d\7\u00bb\2\2\u048d\u048e\7\24\2\2\u048e\u0490"+
		"\7\u00bc\2\2\u048f\u048c\3\2\2\2\u048f\u0490\3\2\2\2\u0490\61\3\2\2\2"+
		"\u0491\u0492\7\u00bd\2\2\u0492\u0493\7\u00f5\2\2\u0493\63\3\2\2\2\u0494"+
		"\u0496\5B\"\2\u0495\u0494\3\2\2\2\u0495\u0496\3\2\2\2\u0496\u0497\3\2"+
		"\2\2\u0497\u0498\5\\/\2\u0498\65\3\2\2\2\u0499\u049a\7W\2\2\u049a\u049b"+
		"\7\u0099\2\2\u049b\u049c\7T\2\2\u049c\u04a3\5\u0094K\2\u049d\u04a1\5:"+
		"\36\2\u049e\u049f\7\177\2\2\u049f\u04a0\7%\2\2\u04a0\u04a2\7\'\2\2\u04a1"+
		"\u049e\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a4\3\2\2\2\u04a3\u049d\3\2"+
		"\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04af\3\2\2\2\u04a5\u04a6\7W\2\2\u04a6"+
		"\u04a8\7Y\2\2\u04a7\u04a9\7T\2\2\u04a8\u04a7\3\2\2\2\u04a8\u04a9\3\2\2"+
		"\2\u04a9\u04aa\3\2\2\2\u04aa\u04ac\5\u0094K\2\u04ab\u04ad\5:\36\2\u04ac"+
		"\u04ab\3\2\2\2\u04ac\u04ad\3\2\2\2\u04ad\u04af\3\2\2\2\u04ae\u0499\3\2"+
		"\2\2\u04ae\u04a5\3\2\2\2\u04af\67\3\2\2\2\u04b0\u04b2\5:\36\2\u04b1\u04b3"+
		"\5\62\32\2\u04b2\u04b1\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b39\3\2\2\2\u04b4"+
		"\u04b5\7F\2\2\u04b5\u04b6\7\4\2\2\u04b6\u04bb\5<\37\2\u04b7\u04b8\7\7"+
		"\2\2\u04b8\u04ba\5<\37\2\u04b9\u04b7\3\2\2\2\u04ba\u04bd\3\2\2\2\u04bb"+
		"\u04b9\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04be\3\2\2\2\u04bd\u04bb\3\2"+
		"\2\2\u04be\u04bf\7\5\2\2\u04bf;\3\2\2\2\u04c0\u04c3\5\u00d2j\2\u04c1\u04c2"+
		"\7\u0080\2\2\u04c2\u04c4\5\u00a8U\2\u04c3\u04c1\3\2\2\2\u04c3\u04c4\3"+
		"\2\2\2\u04c4=\3\2\2\2\u04c5\u04cb\5\u00d0i\2\u04c6\u04cb\7\u00f5\2\2\u04c7"+
		"\u04cb\5\u00aaV\2\u04c8\u04cb\5\u00acW\2\u04c9\u04cb\5\u00aeX\2\u04ca"+
		"\u04c5\3\2\2\2\u04ca\u04c6\3\2\2\2\u04ca\u04c7\3\2\2\2\u04ca\u04c8\3\2"+
		"\2\2\u04ca\u04c9\3\2\2\2\u04cb?\3\2\2\2\u04cc\u04d4\5\u00d2j\2\u04cd\u04d0"+
		"\7\n\2\2\u04ce\u04d1\5\u00d2j\2\u04cf\u04d1\7\u00f5\2\2\u04d0\u04ce\3"+
		"\2\2\2\u04d0\u04cf\3\2\2\2\u04d1\u04d3\3\2\2\2\u04d2\u04cd\3\2\2\2\u04d3"+
		"\u04d6\3\2\2\2\u04d4\u04d2\3\2\2\2\u04d4\u04d5\3\2\2\2\u04d5A\3\2\2\2"+
		"\u04d6\u04d4\3\2\2\2\u04d7\u04d8\7Q\2\2\u04d8\u04dd\5D#\2\u04d9\u04da"+
		"\7\7\2\2\u04da\u04dc\5D#\2\u04db\u04d9\3\2\2\2\u04dc\u04df\3\2\2\2\u04dd"+
		"\u04db\3\2\2\2\u04dd\u04de\3\2\2\2\u04deC\3\2\2\2\u04df\u04dd\3\2\2\2"+
		"\u04e0\u04e2\5\u00d2j\2\u04e1\u04e3\7\24\2\2\u04e2\u04e1\3\2\2\2\u04e2"+
		"\u04e3\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e5\7\4\2\2\u04e5\u04e6\5\64"+
		"\33\2\u04e6\u04e7\7\5\2\2\u04e7E\3\2\2\2\u04e8\u04e9\7\u009c\2\2\u04e9"+
		"\u04ea\5\u00d0i\2\u04eaG\3\2\2\2\u04eb\u04ec\7\4\2\2\u04ec\u04f1\5J&\2"+
		"\u04ed\u04ee\7\7\2\2\u04ee\u04f0\5J&\2\u04ef\u04ed\3\2\2\2\u04f0\u04f3"+
		"\3\2\2\2\u04f1\u04ef\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2\u04f4\3\2\2\2\u04f3"+
		"\u04f1\3\2\2\2\u04f4\u04f5\7\5\2\2\u04f5I\3\2\2\2\u04f6\u04fb\5L\'\2\u04f7"+
		"\u04f9\7\u0080\2\2\u04f8\u04f7\3\2\2\2\u04f8\u04f9\3\2\2\2\u04f9\u04fa"+
		"\3\2\2\2\u04fa\u04fc\5N(\2\u04fb\u04f8\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc"+
		"K\3\2\2\2\u04fd\u0502\5\u00d2j\2\u04fe\u04ff\7\n\2\2\u04ff\u0501\5\u00d2"+
		"j\2\u0500\u04fe\3\2\2\2\u0501\u0504\3\2\2\2\u0502\u0500\3\2\2\2\u0502"+
		"\u0503\3\2\2\2\u0503\u0507\3\2\2\2\u0504\u0502\3\2\2\2\u0505\u0507\7\u00f5"+
		"\2\2\u0506\u04fd\3\2\2\2\u0506\u0505\3\2\2\2\u0507M\3\2\2\2\u0508\u050d"+
		"\7\u00fa\2\2\u0509\u050d\7\u00fb\2\2\u050a\u050d\5\u00b0Y\2\u050b\u050d"+
		"\7\u00f5\2\2\u050c\u0508\3\2\2\2\u050c\u0509\3\2\2\2\u050c\u050a\3\2\2"+
		"\2\u050c\u050b\3\2\2\2\u050dO\3\2\2\2\u050e\u050f\7\4\2\2\u050f\u0514"+
		"\5\u00a8U\2\u0510\u0511\7\7\2\2\u0511\u0513\5\u00a8U\2\u0512\u0510\3\2"+
		"\2\2\u0513\u0516\3\2\2\2\u0514\u0512\3\2\2\2\u0514\u0515\3\2\2\2\u0515"+
		"\u0517\3\2\2\2\u0516\u0514\3\2\2\2\u0517\u0518\7\5\2\2\u0518Q\3\2\2\2"+
		"\u0519\u051a\7\4\2\2\u051a\u051f\5P)\2\u051b\u051c\7\7\2\2\u051c\u051e"+
		"\5P)\2\u051d\u051b\3\2\2\2\u051e\u0521\3\2\2\2\u051f\u051d\3\2\2\2\u051f"+
		"\u0520\3\2\2\2\u0520\u0522\3\2\2\2\u0521\u051f\3\2\2\2\u0522\u0523\7\5"+
		"\2\2\u0523S\3\2\2\2\u0524\u0525\7\u00bb\2\2\u0525\u0526\7\24\2\2\u0526"+
		"\u052b\5V,\2\u0527\u0528\7\u00bb\2\2\u0528\u0529\7\31\2\2\u0529\u052b"+
		"\5X-\2\u052a\u0524\3\2\2\2\u052a\u0527\3\2\2\2\u052bU\3\2\2\2\u052c\u052d"+
		"\7\u00cb\2\2\u052d\u052e\7\u00f5\2\2\u052e\u052f\7\u00cc\2\2\u052f\u0532"+
		"\7\u00f5\2\2\u0530\u0532\5\u00d2j\2\u0531\u052c\3\2\2\2\u0531\u0530\3"+
		"\2\2\2\u0532W\3\2\2\2\u0533\u0537\7\u00f5\2\2\u0534\u0535\7Q\2\2\u0535"+
		"\u0536\7\u009e\2\2\u0536\u0538\5H%\2\u0537\u0534\3\2\2\2\u0537\u0538\3"+
		"\2\2\2\u0538Y\3\2\2\2\u0539\u053a\5\u00d2j\2\u053a\u053b\7\u00f5\2\2\u053b"+
		"[\3\2\2\2\u053c\u053e\5\66\34\2\u053d\u053c\3\2\2\2\u053d\u053e\3\2\2"+
		"\2\u053e\u053f\3\2\2\2\u053f\u0540\5b\62\2\u0540\u0541\5^\60\2\u0541\u0549"+
		"\3\2\2\2\u0542\u0544\5n8\2\u0543\u0545\5`\61\2\u0544\u0543\3\2\2\2\u0545"+
		"\u0546\3\2\2\2\u0546\u0544\3\2\2\2\u0546\u0547\3\2\2\2\u0547\u0549\3\2"+
		"\2\2\u0548\u053d\3\2\2\2\u0548\u0542\3\2\2\2\u0549]\3\2\2\2\u054a\u054b"+
		"\7\36\2\2\u054b\u054c\7\31\2\2\u054c\u0551\5f\64\2\u054d\u054e\7\7\2\2"+
		"\u054e\u0550\5f\64\2\u054f\u054d\3\2\2\2\u0550\u0553\3\2\2\2\u0551\u054f"+
		"\3\2\2\2\u0551\u0552\3\2\2\2\u0552\u0555\3\2\2\2\u0553\u0551\3\2\2\2\u0554"+
		"\u054a\3\2\2\2\u0554\u0555\3\2\2\2\u0555\u0560\3\2\2\2\u0556\u0557\7\u0097"+
		"\2\2\u0557\u0558\7\31\2\2\u0558\u055d\5\u009cO\2\u0559\u055a\7\7\2\2\u055a"+
		"\u055c\5\u009cO\2\u055b\u0559\3\2\2\2\u055c\u055f\3\2\2\2\u055d\u055b"+
		"\3\2\2\2\u055d\u055e\3\2\2\2\u055e\u0561\3\2\2\2\u055f\u055d\3\2\2\2\u0560"+
		"\u0556\3\2\2\2\u0560\u0561\3\2\2\2\u0561\u056c\3\2\2\2\u0562\u0563\7\u0098"+
		"\2\2\u0563\u0564\7\31\2\2\u0564\u0569\5\u009cO\2\u0565\u0566\7\7\2\2\u0566"+
		"\u0568\5\u009cO\2\u0567\u0565\3\2\2\2\u0568\u056b\3\2\2\2\u0569\u0567"+
		"\3\2\2\2\u0569\u056a\3\2\2\2\u056a\u056d\3\2\2\2\u056b\u0569\3\2\2\2\u056c"+
		"\u0562\3\2\2\2\u056c\u056d\3\2\2\2\u056d\u0578\3\2\2\2\u056e\u056f\7\u0096"+
		"\2\2\u056f\u0570\7\31\2\2\u0570\u0575\5f\64\2\u0571\u0572\7\7\2\2\u0572"+
		"\u0574\5f\64\2\u0573\u0571\3\2\2\2\u0574\u0577\3\2\2\2\u0575\u0573\3\2"+
		"\2\2\u0575\u0576\3\2\2\2\u0576\u0579\3\2\2\2\u0577\u0575\3\2\2\2\u0578"+
		"\u056e\3\2\2\2\u0578\u0579\3\2\2\2\u0579\u057b\3\2\2\2\u057a\u057c\5\u00c6"+
		"d\2\u057b\u057a\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u057f\3\2\2\2\u057d"+
		"\u057e\7 \2\2\u057e\u0580\5\u009cO\2\u057f\u057d\3\2\2\2\u057f\u0580\3"+
		"\2\2\2\u0580_\3\2\2\2\u0581\u0583\5\66\34\2\u0582\u0581\3\2\2\2\u0582"+
		"\u0583\3\2\2\2\u0583\u0584\3\2\2\2\u0584\u0585\5h\65\2\u0585\u0586\5^"+
		"\60\2\u0586a\3\2\2\2\u0587\u0588\b\62\1\2\u0588\u0589\5d\63\2\u0589\u0592"+
		"\3\2\2\2\u058a\u058b\f\3\2\2\u058b\u058d\t\t\2\2\u058c\u058e\5v<\2\u058d"+
		"\u058c\3\2\2\2\u058d\u058e\3\2\2\2\u058e\u058f\3\2\2\2\u058f\u0591\5b"+
		"\62\4\u0590\u058a\3\2\2\2\u0591\u0594\3\2\2\2\u0592\u0590\3\2\2\2\u0592"+
		"\u0593\3\2\2\2\u0593c\3\2\2\2\u0594\u0592\3\2\2\2\u0595\u059e\5h\65\2"+
		"\u0596\u0597\7T\2\2\u0597\u059e\5\u0094K\2\u0598\u059e\5\u0090I\2\u0599"+
		"\u059a\7\4\2\2\u059a\u059b\5\\/\2\u059b\u059c\7\5\2\2\u059c\u059e\3\2"+
		"\2\2\u059d\u0595\3\2\2\2\u059d\u0596\3\2\2\2\u059d\u0598\3\2\2\2\u059d"+
		"\u0599\3\2\2\2\u059ee\3\2\2\2\u059f\u05a1\5\u009cO\2\u05a0\u05a2\t\n\2"+
		"\2\u05a1\u05a0\3\2\2\2\u05a1\u05a2\3\2\2\2\u05a2\u05a5\3\2\2\2\u05a3\u05a4"+
		"\7/\2\2\u05a4\u05a6\t\13\2\2\u05a5\u05a3\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6"+
		"g\3\2\2\2\u05a7\u05a8\7\21\2\2\u05a8\u05a9\7\u009a\2\2\u05a9\u05aa\7\4"+
		"\2\2\u05aa\u05ab\5\u009aN\2\u05ab\u05ac\7\5\2\2\u05ac\u05b2\3\2\2\2\u05ad"+
		"\u05ae\7s\2\2\u05ae\u05b2\5\u009aN\2\u05af\u05b0\7\u009b\2\2\u05b0\u05b2"+
		"\5\u009aN\2\u05b1\u05a7\3\2\2\2\u05b1\u05ad\3\2\2\2\u05b1\u05af\3\2\2"+
		"\2\u05b2\u05b4\3\2\2\2\u05b3\u05b5\5\u0092J\2\u05b4\u05b3\3\2\2\2\u05b4"+
		"\u05b5\3\2\2\2\u05b5\u05b8\3\2\2\2\u05b6\u05b7\7\u00a0\2\2\u05b7\u05b9"+
		"\7\u00f5\2\2\u05b8\u05b6\3\2\2\2\u05b8\u05b9\3\2\2\2\u05b9\u05ba\3\2\2"+
		"\2\u05ba\u05bb\7\u009c\2\2\u05bb\u05c8\7\u00f5\2\2\u05bc\u05c6\7\24\2"+
		"\2\u05bd\u05c7\5\u0084C\2\u05be\u05c7\5\u00bc_\2\u05bf\u05c2\7\4\2\2\u05c0"+
		"\u05c3\5\u0084C\2\u05c1\u05c3\5\u00bc_\2\u05c2\u05c0\3\2\2\2\u05c2\u05c1"+
		"\3\2\2\2\u05c3\u05c4\3\2\2\2\u05c4\u05c5\7\5\2\2\u05c5\u05c7\3\2\2\2\u05c6"+
		"\u05bd\3\2\2\2\u05c6\u05be\3\2\2\2\u05c6\u05bf\3\2\2\2\u05c7\u05c9\3\2"+
		"\2\2\u05c8\u05bc\3\2\2\2\u05c8\u05c9\3\2\2\2\u05c9\u05cb\3\2\2\2\u05ca"+
		"\u05cc\5\u0092J\2\u05cb\u05ca\3\2\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05cf"+
		"\3\2\2\2\u05cd\u05ce\7\u009f\2\2\u05ce\u05d0\7\u00f5\2\2\u05cf\u05cd\3"+
		"\2\2\2\u05cf\u05d0\3\2\2\2\u05d0\u05d2\3\2\2\2\u05d1\u05d3\5n8\2\u05d2"+
		"\u05d1\3\2\2\2\u05d2\u05d3\3\2\2\2\u05d3\u05d6\3\2\2\2\u05d4\u05d5\7\27"+
		"\2\2\u05d5\u05d7\5\u009eP\2\u05d6\u05d4\3\2\2\2\u05d6\u05d7\3\2\2\2\u05d7"+
		"\u0605\3\2\2\2\u05d8\u05dc\7\21\2\2\u05d9\u05db\5j\66\2\u05da\u05d9\3"+
		"\2\2\2\u05db\u05de\3\2\2\2\u05dc\u05da\3\2\2\2\u05dc\u05dd\3\2\2\2\u05dd"+
		"\u05e0\3\2\2\2\u05de\u05dc\3\2\2\2\u05df\u05e1\5v<\2\u05e0\u05df\3\2\2"+
		"\2\u05e0\u05e1\3\2\2\2\u05e1\u05e2\3\2\2\2\u05e2\u05e4\5\u009aN\2\u05e3"+
		"\u05e5\5n8\2\u05e4\u05e3\3\2\2\2\u05e4\u05e5\3\2\2\2\u05e5\u05ef\3\2\2"+
		"\2\u05e6\u05ec\5n8\2\u05e7\u05e9\7\21\2\2\u05e8\u05ea\5v<\2\u05e9\u05e8"+
		"\3\2\2\2\u05e9\u05ea\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb\u05ed\5\u009aN"+
		"\2\u05ec\u05e7\3\2\2\2\u05ec\u05ed\3\2\2\2\u05ed\u05ef\3\2\2\2\u05ee\u05d8"+
		"\3\2\2\2\u05ee\u05e6\3\2\2\2\u05ef\u05f3\3\2\2\2\u05f0\u05f2\5t;\2\u05f1"+
		"\u05f0\3\2\2\2\u05f2\u05f5\3\2\2\2\u05f3\u05f1\3\2\2\2\u05f3\u05f4\3\2"+
		"\2\2\u05f4\u05f8\3\2\2\2\u05f5\u05f3\3\2\2\2\u05f6\u05f7\7\27\2\2\u05f7"+
		"\u05f9\5\u009eP\2\u05f8\u05f6\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9\u05fb"+
		"\3\2\2\2\u05fa\u05fc\5p9\2\u05fb\u05fa\3\2\2\2\u05fb\u05fc\3\2\2\2\u05fc"+
		"\u05ff\3\2\2\2\u05fd\u05fe\7\37\2\2\u05fe\u0600\5\u009eP\2\u05ff\u05fd"+
		"\3\2\2\2\u05ff\u0600\3\2\2\2\u0600\u0602\3\2\2\2\u0601\u0603\5\u00c6d"+
		"\2\u0602\u0601\3\2\2\2\u0602\u0603\3\2\2\2\u0603\u0605\3\2\2\2\u0604\u05b1"+
		"\3\2\2\2\u0604\u05ee\3\2\2\2\u0605i\3\2\2\2\u0606\u0607\7\13\2\2\u0607"+
		"\u060e\5l\67\2\u0608\u060a\7\7\2\2\u0609\u0608\3\2\2\2\u0609\u060a\3\2"+
		"\2\2\u060a\u060b\3\2\2\2\u060b\u060d\5l\67\2\u060c\u0609\3\2\2\2\u060d"+
		"\u0610\3\2\2\2\u060e\u060c\3\2\2\2\u060e\u060f\3\2\2\2\u060f\u0611\3\2"+
		"\2\2\u0610\u060e\3\2\2\2\u0611\u0612\7\f\2\2\u0612k\3\2\2\2\u0613\u0621"+
		"\5\u00d2j\2\u0614\u0615\5\u00d2j\2\u0615\u0616\7\4\2\2\u0616\u061b\5\u00a6"+
		"T\2\u0617\u0618\7\7\2\2\u0618\u061a\5\u00a6T\2\u0619\u0617\3\2\2\2\u061a"+
		"\u061d\3\2\2\2\u061b\u0619\3\2\2\2\u061b\u061c\3\2\2\2\u061c\u061e\3\2"+
		"\2\2\u061d\u061b\3\2\2\2\u061e\u061f\7\5\2\2\u061f\u0621\3\2\2\2\u0620"+
		"\u0613\3\2\2\2\u0620\u0614\3\2\2\2\u0621m\3\2\2\2\u0622\u0623\7\22\2\2"+
		"\u0623\u0628\5x=\2\u0624\u0625\7\7\2\2\u0625\u0627\5x=\2\u0626\u0624\3"+
		"\2\2\2\u0627\u062a\3\2\2\2\u0628\u0626\3\2\2\2\u0628\u0629\3\2\2\2\u0629"+
		"\u062e\3\2\2\2\u062a\u0628\3\2\2\2\u062b\u062d\5t;\2\u062c\u062b\3\2\2"+
		"\2\u062d\u0630\3\2\2\2\u062e\u062c\3\2\2\2\u062e\u062f\3\2\2\2\u062fo"+
		"\3\2\2\2\u0630\u062e\3\2\2\2\u0631\u0632\7\30\2\2\u0632\u0633\7\31\2\2"+
		"\u0633\u0638\5\u009cO\2\u0634\u0635\7\7\2\2\u0635\u0637\5\u009cO\2\u0636"+
		"\u0634\3\2\2\2\u0637\u063a\3\2\2\2\u0638\u0636\3\2\2\2\u0638\u0639\3\2"+
		"\2\2\u0639\u064c\3\2\2\2\u063a\u0638\3\2\2\2\u063b\u063c\7Q\2\2\u063c"+
		"\u064d\7\35\2\2\u063d\u063e\7Q\2\2\u063e\u064d\7\34\2\2\u063f\u0640\7"+
		"\32\2\2\u0640\u0641\7\33\2\2\u0641\u0642\7\4\2\2\u0642\u0647\5r:\2\u0643"+
		"\u0644\7\7\2\2\u0644\u0646\5r:\2\u0645\u0643\3\2\2\2\u0646\u0649\3\2\2"+
		"\2\u0647\u0645\3\2\2\2\u0647\u0648\3\2\2\2\u0648\u064a\3\2\2\2\u0649\u0647"+
		"\3\2\2\2\u064a\u064b\7\5\2\2\u064b\u064d\3\2\2\2\u064c\u063b\3\2\2\2\u064c"+
		"\u063d\3\2\2\2\u064c\u063f\3\2\2\2\u064c\u064d\3\2\2\2\u064dq\3\2\2\2"+
		"\u064e\u0657\7\4\2\2\u064f\u0654\5\u009cO\2\u0650\u0651\7\7\2\2\u0651"+
		"\u0653\5\u009cO\2\u0652\u0650\3\2\2\2\u0653\u0656\3\2\2\2\u0654\u0652"+
		"\3\2\2\2\u0654\u0655\3\2\2\2\u0655\u0658\3\2\2\2\u0656\u0654\3\2\2\2\u0657"+
		"\u064f\3\2\2\2\u0657\u0658\3\2\2\2\u0658\u0659\3\2\2\2\u0659\u065c\7\5"+
		"\2\2\u065a\u065c\5\u009cO\2\u065b\u064e\3\2\2\2\u065b\u065a\3\2\2\2\u065c"+
		"s\3\2\2\2\u065d\u065e\7C\2\2\u065e\u0660\7U\2\2\u065f\u0661\7;\2\2\u0660"+
		"\u065f\3\2\2\2\u0660\u0661\3\2\2\2\u0661\u0662\3\2\2\2\u0662\u0663\5\u00d0"+
		"i\2\u0663\u066c\7\4\2\2\u0664\u0669\5\u009cO\2\u0665\u0666\7\7\2\2\u0666"+
		"\u0668\5\u009cO\2\u0667\u0665\3\2\2\2\u0668\u066b\3\2\2\2\u0669\u0667"+
		"\3\2\2\2\u0669\u066a\3\2\2\2\u066a\u066d\3\2\2\2\u066b\u0669\3\2\2\2\u066c"+
		"\u0664\3\2\2\2\u066c\u066d\3\2\2\2\u066d\u066e\3\2\2\2\u066e\u066f\7\5"+
		"\2\2\u066f\u067b\5\u00d2j\2\u0670\u0672\7\24\2\2\u0671\u0670\3\2\2\2\u0671"+
		"\u0672\3\2\2\2\u0672\u0673\3\2\2\2\u0673\u0678\5\u00d2j\2\u0674\u0675"+
		"\7\7\2\2\u0675\u0677\5\u00d2j\2\u0676\u0674\3\2\2\2\u0677\u067a\3\2\2"+
		"\2\u0678\u0676\3\2\2\2\u0678\u0679\3\2\2\2\u0679\u067c\3\2\2\2\u067a\u0678"+
		"\3\2\2\2\u067b\u0671\3\2\2\2\u067b\u067c\3\2\2\2\u067cu\3\2\2\2\u067d"+
		"\u067e\t\f\2\2\u067ew\3\2\2\2\u067f\u0683\5\u008eH\2\u0680\u0682\5z>\2"+
		"\u0681\u0680\3\2\2\2\u0682\u0685\3\2\2\2\u0683\u0681\3\2\2\2\u0683\u0684"+
		"\3\2\2\2\u0684y\3\2\2\2\u0685\u0683\3\2\2\2\u0686\u0687\5|?\2\u0687\u0688"+
		"\79\2\2\u0688\u068a\5\u008eH\2\u0689\u068b\5~@\2\u068a\u0689\3\2\2\2\u068a"+
		"\u068b\3\2\2\2\u068b\u0692\3\2\2\2\u068c\u068d\7A\2\2\u068d\u068e\5|?"+
		"\2\u068e\u068f\79\2\2\u068f\u0690\5\u008eH\2\u0690\u0692\3\2\2\2\u0691"+
		"\u0686\3\2\2\2\u0691\u068c\3\2\2\2\u0692{\3\2\2\2\u0693\u0695\7<\2\2\u0694"+
		"\u0693\3\2\2\2\u0694\u0695\3\2\2\2\u0695\u06aa\3\2\2\2\u0696\u06aa\7:"+
		"\2\2\u0697\u0699\7=\2\2\u0698\u069a\7;\2\2\u0699\u0698\3\2\2\2\u0699\u069a"+
		"\3\2\2\2\u069a\u06aa\3\2\2\2\u069b\u069c\7=\2\2\u069c\u06aa\7>\2\2\u069d"+
		"\u069f\7?\2\2\u069e\u06a0\7;\2\2\u069f\u069e\3\2\2\2\u069f\u06a0\3\2\2"+
		"\2\u06a0\u06aa\3\2\2\2\u06a1\u06a3\7@\2\2\u06a2\u06a4\7;\2\2\u06a3\u06a2"+
		"\3\2\2\2\u06a3\u06a4\3\2\2\2\u06a4\u06aa\3\2\2\2\u06a5\u06a7\7=\2\2\u06a6"+
		"\u06a5\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06a8\3\2\2\2\u06a8\u06aa\7\u00eb"+
		"\2\2\u06a9\u0694\3\2\2\2\u06a9\u0696\3\2\2\2\u06a9\u0697\3\2\2\2\u06a9"+
		"\u069b\3\2\2\2\u06a9\u069d\3\2\2\2\u06a9\u06a1\3\2\2\2\u06a9\u06a6\3\2"+
		"\2\2\u06aa}\3\2\2\2\u06ab\u06ac\7B\2\2\u06ac\u06ba\5\u009eP\2\u06ad\u06ae"+
		"\7\u009c\2\2\u06ae\u06af\7\4\2\2\u06af\u06b4\5\u00d2j\2\u06b0\u06b1\7"+
		"\7\2\2\u06b1\u06b3\5\u00d2j\2\u06b2\u06b0\3\2\2\2\u06b3\u06b6\3\2\2\2"+
		"\u06b4\u06b2\3\2\2\2\u06b4\u06b5\3\2\2\2\u06b5\u06b7\3\2\2\2\u06b6\u06b4"+
		"\3\2\2\2\u06b7\u06b8\7\5\2\2\u06b8\u06ba\3\2\2\2\u06b9\u06ab\3\2\2\2\u06b9"+
		"\u06ad\3\2\2\2\u06ba\177\3\2\2\2\u06bb\u06bc\7n\2\2\u06bc\u06d2\7\4\2"+
		"\2\u06bd\u06be\t\r\2\2\u06be\u06d3\7\u0092\2\2\u06bf\u06c0\5\u009cO\2"+
		"\u06c0\u06c1\7H\2\2\u06c1\u06d3\3\2\2\2\u06c2\u06d3\7\u00f9\2\2\u06c3"+
		"\u06c4\7\u0093\2\2\u06c4\u06c5\7\u00fa\2\2\u06c5\u06c6\7\u0094\2\2\u06c6"+
		"\u06c7\7\u0095\2\2\u06c7\u06d0\7\u00fa\2\2\u06c8\u06ce\7B\2\2\u06c9\u06cf"+
		"\5\u00d2j\2\u06ca\u06cb\5\u00d0i\2\u06cb\u06cc\7\4\2\2\u06cc\u06cd\7\5"+
		"\2\2\u06cd\u06cf\3\2\2\2\u06ce\u06c9\3\2\2\2\u06ce\u06ca\3\2\2\2\u06cf"+
		"\u06d1\3\2\2\2\u06d0\u06c8\3\2\2\2\u06d0\u06d1\3\2\2\2\u06d1\u06d3\3\2"+
		"\2\2\u06d2\u06bd\3\2\2\2\u06d2\u06bf\3\2\2\2\u06d2\u06c2\3\2\2\2\u06d2"+
		"\u06c3\3\2\2\2\u06d3\u06d4\3\2\2\2\u06d4\u06d5\7\5\2\2\u06d5\u0081\3\2"+
		"\2\2\u06d6\u06d7\7\4\2\2\u06d7\u06d8\5\u0084C\2\u06d8\u06d9\7\5\2\2\u06d9"+
		"\u0083\3\2\2\2\u06da\u06df\5\u00d2j\2\u06db\u06dc\7\7\2\2\u06dc\u06de"+
		"\5\u00d2j\2\u06dd\u06db\3\2\2\2\u06de\u06e1\3\2\2\2\u06df\u06dd\3\2\2"+
		"\2\u06df\u06e0\3\2\2\2\u06e0\u0085\3\2\2\2\u06e1\u06df\3\2\2\2\u06e2\u06e3"+
		"\7\4\2\2\u06e3\u06e8\5\u0088E\2\u06e4\u06e5\7\7\2\2\u06e5\u06e7\5\u0088"+
		"E\2\u06e6\u06e4\3\2\2\2\u06e7\u06ea\3\2\2\2\u06e8\u06e6\3\2\2\2\u06e8"+
		"\u06e9\3\2\2\2\u06e9\u06eb\3\2\2\2\u06ea\u06e8\3\2\2\2\u06eb\u06ec\7\5"+
		"\2\2\u06ec\u0087\3\2\2\2\u06ed\u06ef\5\u00d2j\2\u06ee\u06f0\t\n\2\2\u06ef"+
		"\u06ee\3\2\2\2\u06ef\u06f0\3\2\2\2\u06f0\u0089\3\2\2\2\u06f1\u06f2\7\4"+
		"\2\2\u06f2\u06f7\5\u008cG\2\u06f3\u06f4\7\7\2\2\u06f4\u06f6\5\u008cG\2"+
		"\u06f5\u06f3\3\2\2\2\u06f6\u06f9\3\2\2\2\u06f7\u06f5\3\2\2\2\u06f7\u06f8"+
		"\3\2\2\2\u06f8\u06fa\3\2\2\2\u06f9\u06f7\3\2\2\2\u06fa\u06fb\7\5\2\2\u06fb"+
		"\u008b\3\2\2\2\u06fc\u06ff\5\u00d2j\2\u06fd\u06fe\7u\2\2\u06fe\u0700\7"+
		"\u00f5\2\2\u06ff\u06fd\3\2\2\2\u06ff\u0700\3\2\2\2\u0700\u008d\3\2\2\2"+
		"\u0701\u0703\5\u0094K\2\u0702\u0704\5\u0080A\2\u0703\u0702\3\2\2\2\u0703"+
		"\u0704\3\2\2\2\u0704\u0709\3\2\2\2\u0705\u0707\7\24\2\2\u0706\u0705\3"+
		"\2\2\2\u0706\u0707\3\2\2\2\u0707\u0708\3\2\2\2\u0708\u070a\5\u00d4k\2"+
		"\u0709\u0706\3\2\2\2\u0709\u070a\3\2\2\2\u070a\u0733\3\2\2\2\u070b\u070c"+
		"\7\4\2\2\u070c\u070d\5\\/\2\u070d\u070f\7\5\2\2\u070e\u0710\5\u0080A\2"+
		"\u070f\u070e\3\2\2\2\u070f\u0710\3\2\2\2\u0710\u0715\3\2\2\2\u0711\u0713"+
		"\7\24\2\2\u0712\u0711\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0714\3\2\2\2"+
		"\u0714\u0716\5\u00d4k\2\u0715\u0712\3\2\2\2\u0715\u0716\3\2\2\2\u0716"+
		"\u0733\3\2\2\2\u0717\u0718\7\4\2\2\u0718\u0719\5x=\2\u0719\u071b\7\5\2"+
		"\2\u071a\u071c\5\u0080A\2\u071b\u071a\3\2\2\2\u071b\u071c\3\2\2\2\u071c"+
		"\u0721\3\2\2\2\u071d\u071f\7\24\2\2\u071e\u071d\3\2\2\2\u071e\u071f\3"+
		"\2\2\2\u071f\u0720\3\2\2\2\u0720\u0722\5\u00d4k\2\u0721\u071e\3\2\2\2"+
		"\u0721\u0722\3\2\2\2\u0722\u0733\3\2\2\2\u0723\u0733\5\u0090I\2\u0724"+
		"\u0725\5\u00d2j\2\u0725\u072e\7\4\2\2\u0726\u072b\5\u009cO\2\u0727\u0728"+
		"\7\7\2\2\u0728\u072a\5\u009cO\2\u0729\u0727\3\2\2\2\u072a\u072d\3\2\2"+
		"\2\u072b\u0729\3\2\2\2\u072b\u072c\3\2\2\2\u072c\u072f\3\2\2\2\u072d\u072b"+
		"\3\2\2\2\u072e\u0726\3\2\2\2\u072e\u072f\3\2\2\2\u072f\u0730\3\2\2\2\u0730"+
		"\u0731\7\5\2\2\u0731\u0733\3\2\2\2\u0732\u0701\3\2\2\2\u0732\u070b\3\2"+
		"\2\2\u0732\u0717\3\2\2\2\u0732\u0723\3\2\2\2\u0732\u0724\3\2\2\2\u0733"+
		"\u008f\3\2\2\2\u0734\u0735\7R\2\2\u0735\u073a\5\u009cO\2\u0736\u0737\7"+
		"\7\2\2\u0737\u0739\5\u009cO\2\u0738\u0736\3\2\2\2\u0739\u073c\3\2\2\2"+
		"\u073a\u0738\3\2\2\2\u073a\u073b\3\2\2\2\u073b\u0744\3\2\2\2\u073c\u073a"+
		"\3\2\2\2\u073d\u073f\7\24\2\2\u073e\u073d\3\2\2\2\u073e\u073f\3\2\2\2"+
		"\u073f\u0740\3\2\2\2\u0740\u0742\5\u00d2j\2\u0741\u0743\5\u0082B\2\u0742"+
		"\u0741\3\2\2\2\u0742\u0743\3\2\2\2\u0743\u0745\3\2\2\2\u0744\u073e\3\2"+
		"\2\2\u0744\u0745\3\2\2\2\u0745\u0091\3\2\2\2\u0746\u0747\7P\2\2\u0747"+
		"\u0748\7\\\2\2\u0748\u0749\7\u009d\2\2\u0749\u074d\7\u00f5\2\2\u074a\u074b"+
		"\7Q\2\2\u074b\u074c\7\u009e\2\2\u074c\u074e\5H%\2\u074d\u074a\3\2\2\2"+
		"\u074d\u074e\3\2\2\2\u074e\u0778\3\2\2\2\u074f\u0750\7P\2\2\u0750\u0751"+
		"\7\\\2\2\u0751\u075b\7\u00a1\2\2\u0752\u0753\7\u00a2\2\2\u0753\u0754\7"+
		"\u00a3\2\2\u0754\u0755\7\31\2\2\u0755\u0759\7\u00f5\2\2\u0756\u0757\7"+
		"\u00a7\2\2\u0757\u0758\7\31\2\2\u0758\u075a\7\u00f5\2\2\u0759\u0756\3"+
		"\2\2\2\u0759\u075a\3\2\2\2\u075a\u075c\3\2\2\2\u075b\u0752\3\2\2\2\u075b"+
		"\u075c\3\2\2\2\u075c\u0762\3\2\2\2\u075d\u075e\7\u00a4\2\2\u075e\u075f"+
		"\7\u00a5\2\2\u075f\u0760\7\u00a3\2\2\u0760\u0761\7\31\2\2\u0761\u0763"+
		"\7\u00f5\2\2\u0762\u075d\3\2\2\2\u0762\u0763\3\2\2\2\u0763\u0769\3\2\2"+
		"\2\u0764\u0765\7s\2\2\u0765\u0766\7\u00a6\2\2\u0766\u0767\7\u00a3\2\2"+
		"\u0767\u0768\7\31\2\2\u0768\u076a\7\u00f5\2\2\u0769\u0764\3\2\2\2\u0769"+
		"\u076a\3\2\2\2\u076a\u076f\3\2\2\2\u076b\u076c\7\u00a8\2\2\u076c\u076d"+
		"\7\u00a3\2\2\u076d\u076e\7\31\2\2\u076e\u0770\7\u00f5\2\2\u076f\u076b"+
		"\3\2\2\2\u076f\u0770\3\2\2\2\u0770\u0775\3\2\2\2\u0771\u0772\7,\2\2\u0772"+
		"\u0773\7\u00d7\2\2\u0773\u0774\7\24\2\2\u0774\u0776\7\u00f5\2\2\u0775"+
		"\u0771\3\2\2\2\u0775\u0776\3\2\2\2\u0776\u0778\3\2\2\2\u0777\u0746\3\2"+
		"\2\2\u0777\u074f\3\2\2\2\u0778\u0093\3\2\2\2\u0779\u077a\5\u00d2j\2\u077a"+
		"\u077b\7\n\2\2\u077b\u077d\3\2\2\2\u077c\u0779\3\2\2\2\u077c\u077d\3\2"+
		"\2\2\u077d\u077e\3\2\2\2\u077e\u077f\5\u00d2j\2\u077f\u0095\3\2\2\2\u0780"+
		"\u0781\5\u00d2j\2\u0781\u0782\7\n\2\2\u0782\u0784\3\2\2\2\u0783\u0780"+
		"\3\2\2\2\u0783\u0784\3\2\2\2\u0784\u0785\3\2\2\2\u0785\u0786\5\u00d2j"+
		"\2\u0786\u0097\3\2\2\2\u0787\u078f\5\u009cO\2\u0788\u078a\7\24\2\2\u0789"+
		"\u0788\3\2\2\2\u0789\u078a\3\2\2\2\u078a\u078d\3\2\2\2\u078b\u078e\5\u00d2"+
		"j\2\u078c\u078e\5\u0082B\2\u078d\u078b\3\2\2\2\u078d\u078c\3\2\2\2\u078e"+
		"\u0790\3\2\2\2\u078f\u0789\3\2\2\2\u078f\u0790\3\2\2\2\u0790\u0099\3\2"+
		"\2\2\u0791\u0796\5\u0098M\2\u0792\u0793\7\7\2\2\u0793\u0795\5\u0098M\2"+
		"\u0794\u0792\3\2\2\2\u0795\u0798\3\2\2\2\u0796\u0794\3\2\2\2\u0796\u0797"+
		"\3\2\2\2\u0797\u009b\3\2\2\2\u0798\u0796\3\2\2\2\u0799\u079a\5\u009eP"+
		"\2\u079a\u009d\3\2\2\2\u079b\u079c\bP\1\2\u079c\u079d\7%\2\2\u079d\u07a9"+
		"\5\u009eP\b\u079e\u079f\7\'\2\2\u079f\u07a0\7\4\2\2\u07a0\u07a1\5\64\33"+
		"\2\u07a1\u07a2\7\5\2\2\u07a2\u07a9\3\2\2\2\u07a3\u07a4\7\r\2\2\u07a4\u07a5"+
		"\5\u009eP\2\u07a5\u07a6\7\16\2\2\u07a6\u07a9\3\2\2\2\u07a7\u07a9\5\u00a0"+
		"Q\2\u07a8\u079b\3\2\2\2\u07a8\u079e\3\2\2\2\u07a8\u07a3\3\2\2\2\u07a8"+
		"\u07a7\3\2\2\2\u07a9\u07b2\3\2\2\2\u07aa\u07ab\f\4\2\2\u07ab\u07ac\7#"+
		"\2\2\u07ac\u07b1\5\u009eP\5\u07ad\u07ae\f\3\2\2\u07ae\u07af\7\"\2\2\u07af"+
		"\u07b1\5\u009eP\4\u07b0\u07aa\3\2\2\2\u07b0\u07ad\3\2\2\2\u07b1\u07b4"+
		"\3\2\2\2\u07b2\u07b0\3\2\2\2\u07b2\u07b3\3\2\2\2\u07b3\u009f\3\2\2\2\u07b4"+
		"\u07b2\3\2\2\2\u07b5\u07b7\5\u00a4S\2\u07b6\u07b8\5\u00a2R\2\u07b7\u07b6"+
		"\3\2\2\2\u07b7\u07b8\3\2\2\2\u07b8\u00a1\3\2\2\2\u07b9\u07bb\7%\2\2\u07ba"+
		"\u07b9\3\2\2\2\u07ba\u07bb\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc\u07bd\7("+
		"\2\2\u07bd\u07be\5\u00a4S\2\u07be\u07bf\7#\2\2\u07bf\u07c0\5\u00a4S\2"+
		"\u07c0\u07e3\3\2\2\2\u07c1\u07c3\7%\2\2\u07c2\u07c1\3\2\2\2\u07c2\u07c3"+
		"\3\2\2\2\u07c3\u07c4\3\2\2\2\u07c4\u07c5\7$\2\2\u07c5\u07c6\7\4\2\2\u07c6"+
		"\u07cb\5\u009cO\2\u07c7\u07c8\7\7\2\2\u07c8\u07ca\5\u009cO\2\u07c9\u07c7"+
		"\3\2\2\2\u07ca\u07cd\3\2\2\2\u07cb\u07c9\3\2\2\2\u07cb\u07cc\3\2\2\2\u07cc"+
		"\u07ce\3\2\2\2\u07cd\u07cb\3\2\2\2\u07ce\u07cf\7\5\2\2\u07cf\u07e3\3\2"+
		"\2\2\u07d0\u07d2\7%\2\2\u07d1\u07d0\3\2\2\2\u07d1\u07d2\3\2\2\2\u07d2"+
		"\u07d3\3\2\2\2\u07d3\u07d4\7$\2\2\u07d4\u07d5\7\4\2\2\u07d5\u07d6\5\64"+
		"\33\2\u07d6\u07d7\7\5\2\2\u07d7\u07e3\3\2\2\2\u07d8\u07da\7%\2\2\u07d9"+
		"\u07d8\3\2\2\2\u07d9\u07da\3\2\2\2\u07da\u07db\3\2\2\2\u07db\u07dc\t\16"+
		"\2\2\u07dc\u07e3\5\u00a4S\2\u07dd\u07df\7+\2\2\u07de\u07e0\7%\2\2\u07df"+
		"\u07de\3\2\2\2\u07df\u07e0\3\2\2\2\u07e0\u07e1\3\2\2\2\u07e1\u07e3\7,"+
		"\2\2\u07e2\u07ba\3\2\2\2\u07e2\u07c2\3\2\2\2\u07e2\u07d1\3\2\2\2\u07e2"+
		"\u07d9\3\2\2\2\u07e2\u07dd\3\2\2\2\u07e3\u00a3\3\2\2\2\u07e4\u07e5\bS"+
		"\1\2\u07e5\u07e9\5\u00a6T\2\u07e6\u07e7\t\17\2\2\u07e7\u07e9\5\u00a4S"+
		"\t\u07e8\u07e4\3\2\2\2\u07e8\u07e6\3\2\2\2\u07e9\u07ff\3\2\2\2\u07ea\u07eb"+
		"\f\b\2\2\u07eb\u07ec\t\20\2\2\u07ec\u07fe\5\u00a4S\t\u07ed\u07ee\f\7\2"+
		"\2\u07ee\u07ef\t\21\2\2\u07ef\u07fe\5\u00a4S\b\u07f0\u07f1\f\6\2\2\u07f1"+
		"\u07f2\7\u008f\2\2\u07f2\u07fe\5\u00a4S\7\u07f3\u07f4\f\5\2\2\u07f4\u07f5"+
		"\7\u0091\2\2\u07f5\u07fe\5\u00a4S\6\u07f6\u07f7\f\4\2\2\u07f7\u07f8\7"+
		"\u0090\2\2\u07f8\u07fe\5\u00a4S\5\u07f9\u07fa\f\3\2\2\u07fa\u07fb\5\u00aa"+
		"V\2\u07fb\u07fc\5\u00a4S\4\u07fc\u07fe\3\2\2\2\u07fd\u07ea\3\2\2\2\u07fd"+
		"\u07ed\3\2\2\2\u07fd\u07f0\3\2\2\2\u07fd\u07f3\3\2\2\2\u07fd\u07f6\3\2"+
		"\2\2\u07fd\u07f9\3\2\2\2\u07fe\u0801\3\2\2\2\u07ff\u07fd\3\2\2\2\u07ff"+
		"\u0800\3\2\2\2\u0800\u00a5\3\2\2\2\u0801\u07ff\3\2\2\2\u0802\u0803\bT"+
		"\1\2\u0803\u0871\t\22\2\2\u0804\u0806\7\64\2\2\u0805\u0807\5\u00c4c\2"+
		"\u0806\u0805\3\2\2\2\u0807\u0808\3\2\2\2\u0808\u0806\3\2\2\2\u0808\u0809"+
		"\3\2\2\2\u0809\u080c\3\2\2\2\u080a\u080b\7\67\2\2\u080b\u080d\5\u009c"+
		"O\2\u080c\u080a\3\2\2\2\u080c\u080d\3\2\2\2\u080d\u080e\3\2\2\2\u080e"+
		"\u080f\78\2\2\u080f\u0871\3\2\2\2\u0810\u0811\7\64\2\2\u0811\u0813\5\u009c"+
		"O\2\u0812\u0814\5\u00c4c\2\u0813\u0812\3\2\2\2\u0814\u0815\3\2\2\2\u0815"+
		"\u0813\3\2\2\2\u0815\u0816\3\2\2\2\u0816\u0819\3\2\2\2\u0817\u0818\7\67"+
		"\2\2\u0818\u081a\5\u009cO\2\u0819\u0817\3\2\2\2\u0819\u081a\3\2\2\2\u081a"+
		"\u081b\3\2\2\2\u081b\u081c\78\2\2\u081c\u0871\3\2\2\2\u081d\u081e\7`\2"+
		"\2\u081e\u081f\7\4\2\2\u081f\u0820\5\u009cO\2\u0820\u0821\7\24\2\2\u0821"+
		"\u0822\5\u00ba^\2\u0822\u0823\7\5\2\2\u0823\u0871\3\2\2\2\u0824\u0825"+
		"\7t\2\2\u0825\u082e\7\4\2\2\u0826\u082b\5\u0098M\2\u0827\u0828\7\7\2\2"+
		"\u0828\u082a\5\u0098M\2\u0829\u0827\3\2\2\2\u082a\u082d\3\2\2\2\u082b"+
		"\u0829\3\2\2\2\u082b\u082c\3\2\2\2\u082c\u082f\3\2\2\2\u082d\u082b\3\2"+
		"\2\2\u082e\u0826\3\2\2\2\u082e\u082f\3\2\2\2\u082f\u0830\3\2\2\2\u0830"+
		"\u0871\7\5\2\2\u0831\u0832\7M\2\2\u0832\u0833\7\4\2\2\u0833\u0836\5\u009c"+
		"O\2\u0834\u0835\7~\2\2\u0835\u0837\7/\2\2\u0836\u0834\3\2\2\2\u0836\u0837"+
		"\3\2\2\2\u0837\u0838\3\2\2\2\u0838\u0839\7\5\2\2\u0839\u0871\3\2\2\2\u083a"+
		"\u083b\7O\2\2\u083b\u083c\7\4\2\2\u083c\u083f\5\u009cO\2\u083d\u083e\7"+
		"~\2\2\u083e\u0840\7/\2\2\u083f\u083d\3\2\2\2\u083f\u0840\3\2\2\2\u0840"+
		"\u0841\3\2\2\2\u0841\u0842\7\5\2\2\u0842\u0871\3\2\2\2\u0843\u0871\5\u00a8"+
		"U\2\u0844\u0871\7\u008a\2\2\u0845\u0846\5\u00d0i\2\u0846\u0847\7\n\2\2"+
		"\u0847\u0848\7\u008a\2\2\u0848\u0871\3\2\2\2\u0849\u084a\7\4\2\2\u084a"+
		"\u084d\5\u0098M\2\u084b\u084c\7\7\2\2\u084c\u084e\5\u0098M\2\u084d\u084b"+
		"\3\2\2\2\u084e\u084f\3\2\2\2\u084f\u084d\3\2\2\2\u084f\u0850\3\2\2\2\u0850"+
		"\u0851\3\2\2\2\u0851\u0852\7\5\2\2\u0852\u0871\3\2\2\2\u0853\u0854\7\4"+
		"\2\2\u0854\u0855\5\64\33\2\u0855\u0856\7\5\2\2\u0856\u0871\3\2\2\2\u0857"+
		"\u0858\5\u00d0i\2\u0858\u0864\7\4\2\2\u0859\u085b\5v<\2\u085a\u0859\3"+
		"\2\2\2\u085a\u085b\3\2\2\2\u085b\u085c\3\2\2\2\u085c\u0861\5\u009cO\2"+
		"\u085d\u085e\7\7\2\2\u085e\u0860\5\u009cO\2\u085f\u085d\3\2\2\2\u0860"+
		"\u0863\3\2\2\2\u0861\u085f\3\2\2\2\u0861\u0862\3\2\2\2\u0862\u0865\3\2"+
		"\2\2\u0863\u0861\3\2\2\2\u0864\u085a\3\2\2\2\u0864\u0865\3\2\2\2\u0865"+
		"\u0866\3\2\2\2\u0866\u0869\7\5\2\2\u0867\u0868\7E\2\2\u0868\u086a\5\u00ca"+
		"f\2\u0869\u0867\3\2\2\2\u0869\u086a\3\2\2\2\u086a\u0871\3\2\2\2\u086b"+
		"\u0871\5\u00d2j\2\u086c\u086d\7\4\2\2\u086d\u086e\5\u009cO\2\u086e\u086f"+
		"\7\5\2\2\u086f\u0871\3\2\2\2\u0870\u0802\3\2\2\2\u0870\u0804\3\2\2\2\u0870"+
		"\u0810\3\2\2\2\u0870\u081d\3\2\2\2\u0870\u0824\3\2\2\2\u0870\u0831\3\2"+
		"\2\2\u0870\u083a\3\2\2\2\u0870\u0843\3\2\2\2\u0870\u0844\3\2\2\2\u0870"+
		"\u0845\3\2\2\2\u0870\u0849\3\2\2\2\u0870\u0853\3\2\2\2\u0870\u0857\3\2"+
		"\2\2\u0870\u086b\3\2\2\2\u0870\u086c\3\2\2\2\u0871\u087c\3\2\2\2\u0872"+
		"\u0873\f\6\2\2\u0873\u0874\7\17\2\2\u0874\u0875\5\u00a4S\2\u0875\u0876"+
		"\7\20\2\2\u0876\u087b\3\2\2\2\u0877\u0878\f\4\2\2\u0878\u0879\7\n\2\2"+
		"\u0879\u087b\5\u00d2j\2\u087a\u0872\3\2\2\2\u087a\u0877\3\2\2\2\u087b"+
		"\u087e\3\2\2\2\u087c\u087a\3\2\2\2\u087c\u087d\3\2\2\2\u087d\u00a7\3\2"+
		"\2\2\u087e\u087c\3\2\2\2\u087f\u088c\7,\2\2\u0880\u088c\5\u00b2Z\2\u0881"+
		"\u0882\5\u00d2j\2\u0882\u0883\7\u00f5\2\2\u0883\u088c\3\2\2\2\u0884\u088c"+
		"\5\u00d8m\2\u0885\u088c\5\u00b0Y\2\u0886\u0888\7\u00f5\2\2\u0887\u0886"+
		"\3\2\2\2\u0888\u0889\3\2\2\2\u0889\u0887\3\2\2\2\u0889\u088a\3\2\2\2\u088a"+
		"\u088c\3\2\2\2\u088b\u087f\3\2\2\2\u088b\u0880\3\2\2\2\u088b\u0881\3\2"+
		"\2\2\u088b\u0884\3\2\2\2\u088b\u0885\3\2\2\2\u088b\u0887\3\2\2\2\u088c"+
		"\u00a9\3\2\2\2\u088d\u088e\t\23\2\2\u088e\u00ab\3\2\2\2\u088f\u0890\t"+
		"\24\2\2\u0890\u00ad\3\2\2\2\u0891\u0892\t\25\2\2\u0892\u00af\3\2\2\2\u0893"+
		"\u0894\t\26\2\2\u0894\u00b1\3\2\2\2\u0895\u0899\7\63\2\2\u0896\u0898\5"+
		"\u00b4[\2\u0897\u0896\3\2\2\2\u0898\u089b\3\2\2\2\u0899\u0897\3\2\2\2"+
		"\u0899\u089a\3\2\2\2\u089a\u00b3\3\2\2\2\u089b\u0899\3\2\2\2\u089c\u089d"+
		"\5\u00b6\\\2\u089d\u08a0\5\u00d2j\2\u089e\u089f\7m\2\2\u089f\u08a1\5\u00d2"+
		"j\2\u08a0\u089e\3\2\2\2\u08a0\u08a1\3\2\2\2\u08a1\u00b5\3\2\2\2\u08a2"+
		"\u08a4\t\21\2\2\u08a3\u08a2\3\2\2\2\u08a3\u08a4\3\2\2\2\u08a4\u08a5\3"+
		"\2\2\2\u08a5\u08a8\t\r\2\2\u08a6\u08a8\7\u00f5\2\2\u08a7\u08a3\3\2\2\2"+
		"\u08a7\u08a6\3\2\2\2\u08a8\u00b7\3\2\2\2\u08a9\u08ad\7M\2\2\u08aa\u08ab"+
		"\7N\2\2\u08ab\u08ad\5\u00d2j\2\u08ac\u08a9\3\2\2\2\u08ac\u08aa\3\2\2\2"+
		"\u08ad\u00b9\3\2\2\2\u08ae\u08af\7r\2\2\u08af\u08b0\7\u0084\2\2\u08b0"+
		"\u08b1\5\u00ba^\2\u08b1\u08b2\7\u0086\2\2\u08b2\u08d1\3\2\2\2\u08b3\u08b4"+
		"\7s\2\2\u08b4\u08b5\7\u0084\2\2\u08b5\u08b6\5\u00ba^\2\u08b6\u08b7\7\7"+
		"\2\2\u08b7\u08b8\5\u00ba^\2\u08b8\u08b9\7\u0086\2\2\u08b9\u08d1\3\2\2"+
		"\2\u08ba\u08c1\7t\2\2\u08bb\u08bd\7\u0084\2\2\u08bc\u08be\5\u00c0a\2\u08bd"+
		"\u08bc\3\2\2\2\u08bd\u08be\3\2\2\2\u08be\u08bf\3\2\2\2\u08bf\u08c2\7\u0086"+
		"\2\2\u08c0\u08c2\7\u0082\2\2\u08c1\u08bb\3\2\2\2\u08c1\u08c0\3\2\2\2\u08c2"+
		"\u08d1\3\2\2\2\u08c3\u08ce\5\u00d2j\2\u08c4\u08c5\7\4\2\2\u08c5\u08ca"+
		"\7\u00fa\2\2\u08c6\u08c7\7\7\2\2\u08c7\u08c9\7\u00fa\2\2\u08c8\u08c6\3"+
		"\2\2\2\u08c9\u08cc\3\2\2\2\u08ca\u08c8\3\2\2\2\u08ca\u08cb\3\2\2\2\u08cb"+
		"\u08cd\3\2\2\2\u08cc\u08ca\3\2\2\2\u08cd\u08cf\7\5\2\2\u08ce\u08c4\3\2"+
		"\2\2\u08ce\u08cf\3\2\2\2\u08cf\u08d1\3\2\2\2\u08d0\u08ae\3\2\2\2\u08d0"+
		"\u08b3\3\2\2\2\u08d0\u08ba\3\2\2\2\u08d0\u08c3\3\2\2\2\u08d1\u00bb\3\2"+
		"\2\2\u08d2\u08d7\5\u00be`\2\u08d3\u08d4\7\7\2\2\u08d4\u08d6\5\u00be`\2"+
		"\u08d5\u08d3\3\2\2\2\u08d6\u08d9\3\2\2\2\u08d7\u08d5\3\2\2\2\u08d7\u08d8"+
		"\3\2\2\2\u08d8\u00bd\3\2\2\2\u08d9\u08d7\3\2\2\2\u08da\u08db\5\u00d2j"+
		"\2\u08db\u08de\5\u00ba^\2\u08dc\u08dd\7u\2\2\u08dd\u08df\7\u00f5\2\2\u08de"+
		"\u08dc\3\2\2\2\u08de\u08df\3\2\2\2\u08df\u00bf\3\2\2\2\u08e0\u08e5\5\u00c2"+
		"b\2\u08e1\u08e2\7\7\2\2\u08e2\u08e4\5\u00c2b\2\u08e3\u08e1\3\2\2\2\u08e4"+
		"\u08e7\3\2\2\2\u08e5\u08e3\3\2\2\2\u08e5\u08e6\3\2\2\2\u08e6\u00c1\3\2"+
		"\2\2\u08e7\u08e5\3\2\2\2\u08e8\u08e9\5\u00d2j\2\u08e9\u08ea\7\t\2\2\u08ea"+
		"\u08ed\5\u00ba^\2\u08eb\u08ec\7u\2\2\u08ec\u08ee\7\u00f5\2\2\u08ed\u08eb"+
		"\3\2\2\2\u08ed\u08ee\3\2\2\2\u08ee\u00c3\3\2\2\2\u08ef\u08f0\7\65\2\2"+
		"\u08f0\u08f1\5\u009cO\2\u08f1\u08f2\7\66\2\2\u08f2\u08f3\5\u009cO\2\u08f3"+
		"\u00c5\3\2\2\2\u08f4\u08f5\7D\2\2\u08f5\u08fa\5\u00c8e\2\u08f6\u08f7\7"+
		"\7\2\2\u08f7\u08f9\5\u00c8e\2\u08f8\u08f6\3\2\2\2\u08f9\u08fc\3\2\2\2"+
		"\u08fa\u08f8\3\2\2\2\u08fa\u08fb\3\2\2\2\u08fb\u00c7\3\2\2\2\u08fc\u08fa"+
		"\3\2\2\2\u08fd\u08fe\5\u00d2j\2\u08fe\u08ff\7\24\2\2\u08ff\u0900\5\u00ca"+
		"f\2\u0900\u00c9\3\2\2\2\u0901\u092c\5\u00d2j\2\u0902\u0925\7\4\2\2\u0903"+
		"\u0904\7\u0097\2\2\u0904\u0905\7\31\2\2\u0905\u090a\5\u009cO\2\u0906\u0907"+
		"\7\7\2\2\u0907\u0909\5\u009cO\2\u0908\u0906\3\2\2\2\u0909\u090c\3\2\2"+
		"\2\u090a\u0908\3\2\2\2\u090a\u090b\3\2\2\2\u090b\u0926\3\2\2\2\u090c\u090a"+
		"\3\2\2\2\u090d\u090e\t\27\2\2\u090e\u090f\7\31\2\2\u090f\u0914\5\u009c"+
		"O\2\u0910\u0911\7\7\2\2\u0911\u0913\5\u009cO\2\u0912\u0910\3\2\2\2\u0913"+
		"\u0916\3\2\2\2\u0914\u0912\3\2\2\2\u0914\u0915\3\2\2\2\u0915\u0918\3\2"+
		"\2\2\u0916\u0914\3\2\2\2\u0917\u090d\3\2\2\2\u0917\u0918\3\2\2\2\u0918"+
		"\u0923\3\2\2\2\u0919\u091a\t\30\2\2\u091a\u091b\7\31\2\2\u091b\u0920\5"+
		"f\64\2\u091c\u091d\7\7\2\2\u091d\u091f\5f\64\2\u091e\u091c\3\2\2\2\u091f"+
		"\u0922\3\2\2\2\u0920\u091e\3\2\2\2\u0920\u0921\3\2\2\2\u0921\u0924\3\2"+
		"\2\2\u0922\u0920\3\2\2\2\u0923\u0919\3\2\2\2\u0923\u0924\3\2\2\2\u0924"+
		"\u0926\3\2\2\2\u0925\u0903\3\2\2\2\u0925\u0917\3\2\2\2\u0926\u0928\3\2"+
		"\2\2\u0927\u0929\5\u00ccg\2\u0928\u0927\3\2\2\2\u0928\u0929\3\2\2\2\u0929"+
		"\u092a\3\2\2\2\u092a\u092c\7\5\2\2\u092b\u0901\3\2\2\2\u092b\u0902\3\2"+
		"\2\2\u092c\u00cb\3\2\2\2\u092d\u092e\7G\2\2\u092e\u093e\5\u00ceh\2\u092f"+
		"\u0930\7H\2\2\u0930\u093e\5\u00ceh\2\u0931\u0932\7G\2\2\u0932\u0933\7"+
		"(\2\2\u0933\u0934\5\u00ceh\2";
	private static final String _serializedATNSegment1 =
		"\u0934\u0935\7#\2\2\u0935\u0936\5\u00ceh\2\u0936\u093e\3\2\2\2\u0937\u0938"+
		"\7H\2\2\u0938\u0939\7(\2\2\u0939\u093a\5\u00ceh\2\u093a\u093b\7#\2\2\u093b"+
		"\u093c\5\u00ceh\2\u093c\u093e\3\2\2\2\u093d\u092d\3\2\2\2\u093d\u092f"+
		"\3\2\2\2\u093d\u0931\3\2\2\2\u093d\u0937\3\2\2\2\u093e\u00cd\3\2\2\2\u093f"+
		"\u0940\7I\2\2\u0940\u0947\t\31\2\2\u0941\u0942\7L\2\2\u0942\u0947\7P\2"+
		"\2\u0943\u0944\5\u009cO\2\u0944\u0945\t\31\2\2\u0945\u0947\3\2\2\2\u0946"+
		"\u093f\3\2\2\2\u0946\u0941\3\2\2\2\u0946\u0943\3\2\2\2\u0947\u00cf\3\2"+
		"\2\2\u0948\u094d\5\u00d2j\2\u0949\u094a\7\n\2\2\u094a\u094c\5\u00d2j\2"+
		"\u094b\u0949\3\2\2\2\u094c\u094f\3\2\2\2\u094d\u094b\3\2\2\2\u094d\u094e"+
		"\3\2\2\2\u094e\u00d1\3\2\2\2\u094f\u094d\3\2\2\2\u0950\u0960\5\u00d4k"+
		"\2\u0951\u0960\7\u00eb\2\2\u0952\u0960\7@\2\2\u0953\u0960\7<\2\2\u0954"+
		"\u0960\7=\2\2\u0955\u0960\7>\2\2\u0956\u0960\7?\2\2\u0957\u0960\7A\2\2"+
		"\u0958\u0960\79\2\2\u0959\u0960\7:\2\2\u095a\u0960\7B\2\2\u095b\u0960"+
		"\7i\2\2\u095c\u0960\7l\2\2\u095d\u0960\7j\2\2\u095e\u0960\7k\2\2\u095f"+
		"\u0950\3\2\2\2\u095f\u0951\3\2\2\2\u095f\u0952\3\2\2\2\u095f\u0953\3\2"+
		"\2\2\u095f\u0954\3\2\2\2\u095f\u0955\3\2\2\2\u095f\u0956\3\2\2\2\u095f"+
		"\u0957\3\2\2\2\u095f\u0958\3\2\2\2\u095f\u0959\3\2\2\2\u095f\u095a\3\2"+
		"\2\2\u095f\u095b\3\2\2\2\u095f\u095c\3\2\2\2\u095f\u095d\3\2\2\2\u095f"+
		"\u095e\3\2\2\2\u0960\u00d3\3\2\2\2\u0961\u0966\7\u00fe\2\2\u0962\u0966"+
		"\7\u0100\2\2\u0963\u0966\5\u00d6l\2\u0964\u0966\5\u00dan\2\u0965\u0961"+
		"\3\2\2\2\u0965\u0962\3\2\2\2\u0965\u0963\3\2\2\2\u0965\u0964\3\2\2\2\u0966"+
		"\u00d5\3\2\2\2\u0967\u0968\7\u00ff\2\2\u0968\u00d7\3\2\2\2\u0969\u096b"+
		"\7\u0089\2\2\u096a\u0969\3\2\2\2\u096a\u096b\3\2\2\2\u096b\u096c\3\2\2"+
		"\2\u096c\u0986\7\u00fb\2\2\u096d\u096f\7\u0089\2\2\u096e\u096d\3\2\2\2"+
		"\u096e\u096f\3\2\2\2\u096f\u0970\3\2\2\2\u0970\u0986\7\u00fa\2\2\u0971"+
		"\u0973\7\u0089\2\2\u0972\u0971\3\2\2\2\u0972\u0973\3\2\2\2\u0973\u0974"+
		"\3\2\2\2\u0974\u0986\7\u00f6\2\2\u0975\u0977\7\u0089\2\2\u0976\u0975\3"+
		"\2\2\2\u0976\u0977\3\2\2\2\u0977\u0978\3\2\2\2\u0978\u0986\7\u00f7\2\2"+
		"\u0979\u097b\7\u0089\2\2\u097a\u0979\3\2\2\2\u097a\u097b\3\2\2\2\u097b"+
		"\u097c\3\2\2\2\u097c\u0986\7\u00f8\2\2\u097d\u097f\7\u0089\2\2\u097e\u097d"+
		"\3\2\2\2\u097e\u097f\3\2\2\2\u097f\u0980\3\2\2\2\u0980\u0986\7\u00fc\2"+
		"\2\u0981\u0983\7\u0089\2\2\u0982\u0981\3\2\2\2\u0982\u0983\3\2\2\2\u0983"+
		"\u0984\3\2\2\2\u0984\u0986\7\u00fd\2\2\u0985\u096a\3\2\2\2\u0985\u096e"+
		"\3\2\2\2\u0985\u0972\3\2\2\2\u0985\u0976\3\2\2\2\u0985\u097a\3\2\2\2\u0985"+
		"\u097e\3\2\2\2\u0985\u0982\3\2\2\2\u0986\u00d9\3\2\2\2\u0987\u0988\t\32"+
		"\2\2\u0988\u00db\3\2\2\2\u014e\u00de\u00e0\u00e6\u00f1\u00f7\u00fb\u010a"+
		"\u0114\u011f\u0123\u0129\u0132\u013a\u0141\u0148\u014c\u0165\u016a\u016d"+
		"\u0172\u017f\u0183\u018a\u018f\u0194\u0197\u019a\u019e\u01a1\u01a4\u01ab"+
		"\u01af\u01b7\u01ba\u01bd\u01c0\u01c3\u01c6\u01ca\u01cd\u01d0\u01d7\u01dd"+
		"\u01e3\u01eb\u020b\u0213\u0217\u021c\u0222\u022a\u0230\u023d\u0242\u024b"+
		"\u0250\u0260\u0267\u026b\u0273\u027a\u0281\u0290\u0294\u029a\u02a0\u02a3"+
		"\u02a6\u02ac\u02b0\u02b4\u02b9\u02bd\u02c5\u02c8\u02d1\u02d6\u02dc\u02e2"+
		"\u02ee\u02f1\u02f5\u02fa\u02ff\u0306\u0309\u030c\u0313\u0318\u031e\u0327"+
		"\u032f\u0335\u0339\u033d\u0341\u0343\u034c\u0352\u0357\u035a\u035e\u0361"+
		"\u036a\u036f\u0374\u0377\u037d\u0385\u038a\u0390\u0396\u03a1\u03a9\u03b0"+
		"\u03b8\u03bb\u03c3\u03c7\u03ce\u0442\u044a\u0452\u045b\u0467\u046b\u046e"+
		"\u0474\u047e\u048a\u048f\u0495\u04a1\u04a3\u04a8\u04ac\u04ae\u04b2\u04bb"+
		"\u04c3\u04ca\u04d0\u04d4\u04dd\u04e2\u04f1\u04f8\u04fb\u0502\u0506\u050c"+
		"\u0514\u051f\u052a\u0531\u0537\u053d\u0546\u0548\u0551\u0554\u055d\u0560"+
		"\u0569\u056c\u0575\u0578\u057b\u057f\u0582\u058d\u0592\u059d\u05a1\u05a5"+
		"\u05b1\u05b4\u05b8\u05c2\u05c6\u05c8\u05cb\u05cf\u05d2\u05d6\u05dc\u05e0"+
		"\u05e4\u05e9\u05ec\u05ee\u05f3\u05f8\u05fb\u05ff\u0602\u0604\u0609\u060e"+
		"\u061b\u0620\u0628\u062e\u0638\u0647\u064c\u0654\u0657\u065b\u0660\u0669"+
		"\u066c\u0671\u0678\u067b\u0683\u068a\u0691\u0694\u0699\u069f\u06a3\u06a6"+
		"\u06a9\u06b4\u06b9\u06ce\u06d0\u06d2\u06df\u06e8\u06ef\u06f7\u06ff\u0703"+
		"\u0706\u0709\u070f\u0712\u0715\u071b\u071e\u0721\u072b\u072e\u0732\u073a"+
		"\u073e\u0742\u0744\u074d\u0759\u075b\u0762\u0769\u076f\u0775\u0777\u077c"+
		"\u0783\u0789\u078d\u078f\u0796\u07a8\u07b0\u07b2\u07b7\u07ba\u07c2\u07cb"+
		"\u07d1\u07d9\u07df\u07e2\u07e8\u07fd\u07ff\u0808\u080c\u0815\u0819\u082b"+
		"\u082e\u0836\u083f\u084f\u085a\u0861\u0864\u0869\u0870\u087a\u087c\u0889"+
		"\u088b\u0899\u08a0\u08a3\u08a7\u08ac\u08bd\u08c1\u08ca\u08ce\u08d0\u08d7"+
		"\u08de\u08e5\u08ed\u08fa\u090a\u0914\u0917\u0920\u0923\u0925\u0928\u092b"+
		"\u093d\u0946\u094d\u095f\u0965\u096a\u096e\u0972\u0976\u097a\u097e\u0982"+
		"\u0985";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}