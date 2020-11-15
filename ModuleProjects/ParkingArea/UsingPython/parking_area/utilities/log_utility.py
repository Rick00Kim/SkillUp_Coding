import logging

# create logger
logger = logging.getLogger('parkingArea')
logger.setLevel(logging.DEBUG)
# create console handler and set level to debug
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)

# create formatter
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')

# add formatter to ch
ch.setFormatter(formatter)

# add ch to logger
logger.addHandler(ch)


def output_info_log(message):
    logger.info(message)


def output_warn_log(message):
    logger.warn(message)


def output_error_log(message):
    logger.error(message)


def output_critical_log(message):
    logger.critical(message)
